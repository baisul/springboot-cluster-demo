pipeline {
    agent any

    stages {
        stage('拉取代码') {
            steps {
                checkout scm
            }
        }

        stage('构建应用') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew clean build
                '''
            }
        }

        stage('部署') {
            steps {
                sh '''
                    cd /opt/composeDemo
                    ./deploy.sh
                '''
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