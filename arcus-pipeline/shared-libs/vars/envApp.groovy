def call() {
    stage('环境验证') {
        steps {
            sh """
                echo "=== 执行用户 ==="
                whoami
            
                echo "=== 验证Java环境 ==="
                java -version
                
                echo "=== 验证Docker环境 ==="
                docker --version
                
                echo "=== 验证Kubectl环境 ==="
                kubectl version --client
                
                echo "=== 验证Maven环境 ==="
                mvn --version
            """
        }
    }
}

