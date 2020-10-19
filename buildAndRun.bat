@echo off
call mvn clean package
call docker build -t com.avbravo/restclient .
call docker rm -f restclient
call docker run -d -p 9080:9080 -p 9443:9443 --name restclient com.avbravo/restclient