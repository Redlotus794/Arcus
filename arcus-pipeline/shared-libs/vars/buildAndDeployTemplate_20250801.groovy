// arcus-pipeline/shared-libs/vars/buildAndDeployTemplate.groovy

/**
 * 可选参数列表
 * - imageName: Docker 镜像名称，必填
 * - imageTag: Docker 镜像标签，默认为 "lts"
 * - namespace: Kubernetes 命名空间，默认为 "arcus"
 * - gitRepo: Git 仓库地址，默认为环境变量 ARCUS_GIT_REPO_URL
 * - gitBranch: Git 分支，默认为 "main"
 * - projectDir: 项目目录，必填
 * - profiles: Spring Profiles，必填，可以是字符串或字符串列表
 *
 * @param config
 * @return
 */

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

                        if (!config.profiles) {
                            config.profiles = 'default' // 默认值
                        }

                        // 在这里设置环境变量
                        env.IMAGE_NAME = config.imageName
                        env.IMAGE_TAG = config.imageTag ?: "lts"
                        env.NAMESPACE = config.namespace ?: "arcus"
                        env.GIT_REPO = config.gitRepo ?: env.ARCUS_GIT_REPO_URL ?: ""
                        env.GIT_BRANCH = config.gitBranch ?: "main"
                        env.PROFILES = config.profiles instanceof List ? config.profiles.join(',') : config.profiles

                        if (!env.GIT_REPO) {
                            error("gitRepo is required")
                        }

                        echo "IMAGE_NAME: ${env.IMAGE_NAME}"
                        echo "IMAGE_TAG: ${env.IMAGE_TAG}"
                        echo "NAMESPACE: ${env.NAMESPACE}"
                        echo "GIT_REPO: ${env.GIT_REPO}"
                        echo "GIT_BRANCH: ${env.GIT_BRANCH}"
                        echo "PROFILES: ${env.PROFILES}"
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
                    script {
                        // 清理分支名称，移除origin/前缀
                        def cleanBranch = env.GIT_BRANCH
                        if (cleanBranch.startsWith('origin/')) {
                            cleanBranch = cleanBranch.substring(7) // 移除 "origin/"
                        }

                        echo "Original GIT_BRANCH: ${env.GIT_BRANCH}"
                        echo "Clean branch: ${cleanBranch}"

                        // git checkout 也在 script 块中执行
                        checkout([
                                $class: 'GitSCM',
                                branches: [[name: "*/${cleanBranch}"]],
                                userRemoteConfigs: [[url: env.GIT_REPO]]
                        ])
                    }

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

                        script {
                            // 设置环境变量，使用 profiles 而不是 environment
                            sh """
                                export SPRING_ACTIVE_PROFILES=${env.PROFILES}
                                envsubst < ${K8S_DEPLOY_CONFIG} | kubectl apply -f -
                            """
                        }
                    }
                }
            }
        }
    }
}

