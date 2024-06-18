pipeline {
    agent any

    tools {
        gradle 'Gradle 3.3.0'
    }

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64' // Adjust this to your Java home path
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Ankit-Asthana007/JenkinTest'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'RemoteServer',
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'build/libs/*.jar',
                                    removePrefix: 'build/libs',
                                    remoteDirectory: '/remote/directory'
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false
                        )
                    ]
                )
            }
        }
    }
}
