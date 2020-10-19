# Project com.avbravo/restclient

Steps to run this project:

1. Start your Docker daemon
2. Execute `./buildAndRun.sh` (Linux/MacOs) or `buildAndRun.bat` (Windows)
3. Wait until Open Liberty is up- and running (e.g. use `docker logs -f CONTAINER_ID`)
4. Visit http://localhost:9080/resources/sample
Swagger
http://avbravo:9001/restclientserver/resources/openapi-ui/index.html