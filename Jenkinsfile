node {
    stage('Clone'){
        dir('.'){
            git 'https://github.com/God1Raven/DeliveryApp'
        }
    }

    stage (Build){
        with gradle {
            sh './gradlew build --stacktrace -i'
        }
    }
}