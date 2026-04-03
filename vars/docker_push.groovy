def call(String project, String Imagetag, String dockerhubuser)
{
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) 
    {
        sh """
        echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
        docker tag ${project}:${Imagetag} ${dockerhubuser}/${project}:${Imagetag}
        docker push ${dockerhubuser}/${project}:${Imagetag}
        """
    }
}
