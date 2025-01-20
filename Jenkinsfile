pipeline {
    agent any

    environment {
        GRADLE_HOME = 'C:/workspace/gradle-8.12-bin/gradle-8.12'
        PATH = "$GRADLE_HOME/bin:$PATH"
        JAVA_HOME = 'C:/workspace/OpenJDK17U-jdk_x64_windows_hotspot_17.0.13_11/jdk-17.0.13+11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    // Ejecutar pruebas con Gradle
                    bat './gradlew test'
                }
            }
        }
    }

    post {
        always {
            // Publica los resultados de prueba, independientemente de si la ejecución fue exitosa o no
            junit 'build/test-results/test/*.xml'
        }
    }
}