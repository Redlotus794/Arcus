// arcus-pipeline/shared-libs/vars/buildAndDeployTemplate.groovy
def call(Map config) {
    pipeline {
        agent any

        environment {
            VERSION = "20250801"
        }

        options {
            buildDiscarder(logRotator(numToKeepStr: '1'))
        }

        tools {
            maven "Maven 3.9.6"
        }

        stages {
            stage('加载全局配置') {
                steps {
                    script {
                        loadGlobalVars()
                    }
                }
            }

            stage('初始化配置') {
                steps {
                    script {
                        // 必填校验
                        if (!config.imageName) {
                            error("imageName is required")
                        }

                        if (!config.projectDir) {
                            error("projectDir is required")
                        }

                        // 在这里设置环境变量
                        env.IMAGE_NAME = config.imageName
                        env.IMAGE_TAG = config.imageTag ?: "lts"
                        env.NAMESPACE = config.namespace ?: "arcus"
                        env.GIT_REPO = config.gitRepo ?: env.ARCUS_GIT_REPO_URL ?: ""
                        env.GIT_BRANCH = config.gitBranch ?: "main"

                        if (!env.GIT_REPO) {
                            error("gitRepo is required")
                        }

                        echo "IMAGE_NAME: ${env.IMAGE_NAME}"
                        echo "IMAGE_TAG: ${env.IMAGE_TAG}"
                        echo "NAMESPACE: ${env.NAMESPACE}"
                        echo "GIT_BRANCH: ${env.GIT_BRANCH}"
                    }
                }
            }

            stage('环境验证') {
                steps {
                    script {
                        envVerification()
                    }
                }
            }

            stage('Build') {
                steps {
                    git branch: "${GIT_BRANCH}",
                            url: "${GIT_REPO}"

                    sh 'ls -la'

                    dir(config.projectDir) {
                        sh 'ls -la'
                        sh "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
                }

                post {
                    success {
                        junit "${config.projectDir}/target/surefire-reports/TEST-*.xml"
                        archiveArtifacts "${config.projectDir}/target/*.jar"
                    }
                }
            }

            stage('Docker Build') {
                steps {
                    dir(config.projectDir) {
                        sh """
                            echo "构建Docker镜像..."
                            docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .
                            docker images
                        """
                    }
                }
            }

            stage('Deploy to K8s') {
                steps {
                    dir(config.projectDir) {
                        script {
                            def timestamp = new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'", TimeZone.getTimeZone("UTC"))
                            sh """
                                if [[ "\$(uname)" == "Darwin" ]]; then
                                    sed -i '' "s/last-updated:.*/last-updated: \\\"${timestamp}\\\"/" ${K8S_DEPLOY_CONFIG}
                                else
                                    sed -i "s/last-updated:.*/last-updated: \\\"${timestamp}\\\"/" ${K8S_DEPLOY_CONFIG}
                                fi
                            """
                        }

                        sh """
                            kubectl apply -f ${K8S_DEPLOY_CONFIG}
                        """
                    }
                }
            }
        }
    }
}