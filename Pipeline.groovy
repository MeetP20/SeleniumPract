node {
    try {
        stage('Cloning Repo') {
            dir('RepoName') {
                checkout([$class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/rajprajapati1997/JavascriptWithSelinumWebDriver.git']]
                ])
            }
        }
        
        stage('Installing Dependencies') {
            dir('RepoName') {
                sh """ 
                mvn clean test
                """
            }
        }
        
        stage('Publish Test Report') {
            dir('RepoName') {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: false,
                    reportDir: 'target',
                    reportFiles: 'extentReport.html',
                    reportName: 'Extent Report',
                    reportTitles: 'Test Execution Results'
                ])
            }
        }
        
        stage('Cleanup') {
            dir('RepoName') {
                deleteDir()
            }
        }
    } 
    catch (exec) {
        echo "Failed : ${exec}"
        currentBuild.result = "FAILURE"
    } 
    finally {
        cleanWs()
        if (currentBuild.result == "FAILURE") {
            echo "Pipeline failed"
        } else if (currentBuild.result == "UNSTABLE") {
            echo "Pipeline unstable"
        } else {
            echo "Successfully executed"
        }
    }
}
