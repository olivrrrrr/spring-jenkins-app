node {
	def app
	def image = 'https://github.com/olivrrrrr/spring-jenkins-app/blob/main/Jenkinsfile'
	def branch = 'main'

	try {
		stage('Clone repository') {
	    	git branch: branch,
	        	git branch: 'main', credentialsId:'GITHUB_CREDENTIALS', url:"https://github.com/olivrrrrr/jenkins_docker_test"
	    }

		stage('Build JAR') {
	    	docker.image('maven:3.8.4-openjdk-17').inside('-v /root/.m2:/root/.m2') {
	        	sh 'mvn -B clean package'
	        	stash includes: '**/target/*.jar', name: 'jar'
	    	}
	    }

	    stage('Build Image') {
	    	unstash 'jar'
			app = docker.build image
	    }

	    stage('Push') {
	    	docker.withRegistry('https://registry.hub.docker.com', 'ebeba7f2-fd62-4990-bae4-d982b6adcb80') {
				app.push("${env.BUILD_NUMBER}")
	        }
	    }
	} catch (e) {
		echo 'Error occurred during build process!'
		echo e.toString()
		currentBuild.result = 'FAILURE'
	} finally {
        //junit '**/target/surefire-reports/TEST-*.xml'
        echo 'end'
	}
}