pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                sh '/opt/composeDemo/deploy.sh'
            }
        }
    }

    post {
        success {
            echo "🎉 部署成功！"
        }
        failure {
            echo "❌ 部署失败，请检查日志。"
        }
    }
}
