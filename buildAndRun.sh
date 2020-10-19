#!/bin/sh
mvn clean package && docker build -t com.avbravo/restclient .
docker rm -f restclient || true && docker run -d -p 9080:9080 -p 9443:9443 --name restclient com.avbravo/restclient