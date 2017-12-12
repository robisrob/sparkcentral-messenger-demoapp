// vi: ft=groovy ts=4 sw=4 sts=4

library 'jenkinsTools'

makeWorkflow {
    node = 'java8'
    app = 'sparkcentral-messenger-demoapp'

    amiPlaybooks = ['sparkcentral-messenger-demoapp:docker']

    publishDocker = true
	publishMake = true
    deployAmi = true
    versionMode = 'tag'
}

