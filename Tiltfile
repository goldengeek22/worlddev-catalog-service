#BUILD
custom_build(
    # Name of the container image
    ref = 'worlddev-catalog-service',
    # Command to build the container image
    command = './gradlew bootBuildImage --offline --imageName $EXPECTED_REF',
    # command = './gradlew bootJar --offline ; docker build -t worlddev-catalog-service .',
    # Files to watch that trigger a new build
    deps = ['build.gradle', 'src']
)

#DEPLOY
k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])

#Manage
k8s_resource('worlddev-catalog-service', port_forwards=['9001'])
