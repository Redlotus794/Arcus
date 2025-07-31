@Library('shared-libs') _

pipeline {
    agent any

    options {
        // 配置构建保留策略
        buildDiscarder(logRotator(numToKeepStr: '1'))
    }

    environment {
        IMAGE_NAME = 'arcus-gateway'
        IMAGE_TAG = "lts"
    }

    tools {
        maven "Maven 3.9.6"
    }

    stages {
        stage('环境验证') {
            steps {
                script {
                    envApp()
                }
            }
        }
        stage('Build') {
            steps {
                // 拉取SIT分支代码
                git branch: 'sit',
                        url: 'https://github.com/Redlotus794/Arucs.git'

                // 调试步骤：显示工作目录内容
                sh 'ls -la'

                // 切换到arcus-gateway目录执行Maven命令
                dir('arcus-gateway') {
                    sh 'ls -la'  // 显示项目目录内容，确认pom.xml存在
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }

            post {
                success {
                    // 更新路径模式以匹配子目录中的测试报告和JAR文件
                    junit 'arcus-gateway/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'arcus-gateway/target/*.jar'
                }
            }
        }

        stage('Docker Build') {
            steps {
                // 切换到项目目录
                dir('arcus-gateway') {
                    sh """
                        # 使用完整路径执行Docker命令
                        echo "构建Docker镜像..."
                        docker build -t arcus-gateway:${IMAGE_TAG} .
                        
                        # 查看已构建的镜像
                        docker images
                    """
                }
            }
        }

        stage('Deploy to K8s') {
            steps {
                // 切换到项目目录
                dir('arcus-gateway') {
                    script {
                        def timestamp = new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'", TimeZone.getTimeZone("UTC"))
                        // 动态替换 deployment.yaml 中的注解
                        sh """
                            # 判断是 macOS 还是 Linux，并使用对应的 sed 命令
                            if [[ "\$(uname)" == "Darwin" ]]; then
                                sed -i '' "s/last-updated:.*/last-updated: \\\"${timestamp}\\\"/" k8s/deployment.yaml
                            else
                                sed -i "s/last-updated:.*/last-updated: \\\"${timestamp}\\\"/" k8s/deployment.yaml
                            fi
                        """
                    }

                    sh """
                        # 执行kubectl命令
                        kubectl apply -f k8s/deployment.yaml
                    """
                }
            }
        }
    }
}
