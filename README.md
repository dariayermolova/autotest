# autotest
autotest for solidopinion
ims + my.so + headline

**jenkins**
`docker run -i --rm --name maven-tests -u $(id -u):$(id -g) -v $(pwd)/my_so/:/usr/src/maven-tests -w /usr/src/maven-tests markhobson/maven-chrome mvn clean test || true`

