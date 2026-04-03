def call(String ProjectName, String Imagetag, String DockerHubUser)
{
    echo "Start the Building Process"
    
    sh """
    docker build -t ${DockerHubUser}/${ProjectName}:${Imagetag} .
    """
    
    echo "Building Complete"
}
