pipeline {
    agent any
    tools{
        maven 'my-maven'
    }

    stages {
        stage('0. 자동화 확인') {
            steps {
                echo '스테이지 출발'
            }
        }
        stage('1. 메이븐으로 Build') {
            steps {
                echo '메이븐으로 빌드'
                sh 'mvn clean package'
            }
        }
        stage('2. Docker 버전 확인') {
            steps {
                echo 'Docker 버전 확인'
                sh 'docker version'
                }
        }
        stage('3. Docker(image) Build') {
            steps {
                echo 'Docker 파일 빌드'
                sh 'docker build -t myex-app:latest .'
            }
        }
        stage('4. Docker 컨테이너로 Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-cred',
                    usernameVariable: 'DOCKERHUB_USERNAME',
                    passwordVariable: 'DOCKERHUB_PASSWORD'
                )]) {
                    sh '''
                    echo "$DOCKERHUB_PASSWORD" | docker login -u "$DOCKERHUB_USERNAME" --password-stdin
                    docker tag ex01-app:latest $DOCKERHUB_USERNAME/myex-app:latest
                    docker push $DOCKERHUB_USERNAME/myex-app:latest
                    '''
                }
            }
        }
    }
}