node {
    stage('Clone'){
        dir('.'){
            git 'https://github.com/God1Raven/DeliveryApp'
        }
    }

    stage('Build'){
        sh './gradlew clean build --stacktrace -i'
    }
}