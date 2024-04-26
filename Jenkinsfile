node {
    stage('Clone'){
        dir('.'){
            git 'https://github.com/God1Raven/DeliveryApp'
        }
    }

    stage('Build'){
        withGradle {
            sh './gradlew build --stacktrace -i'
        }
    }
}