#!/bin/bash

function docker-build {
	docker build /Users/oksanakoyro/work/test -t test:latest
}

function docker-run {
	docker run -it --cap-add=SYS_ADMIN --name myjenkins -p 8080:8080 -p 50000:50000 -v myjenkins:/var/jenkins_home test:latest
}
