# Ejecutar

Desde el directorio del archivo pom.xml

mvn clean install


Ejecutar el proyecto

java -jar target/microprofilerestclientserver-microbundle.jar 

## Docker

# ----------------------------
# Imagen desde un war
# ----------------------------
Build de la imagen

docker build -t payara-uber-jar .
Ejecutar

docker run -d -p 8080:8080 --name uber-jar payara-uber-jar
Crear una red

 docker network create mynetwork

Ejecutar en una misma red

docker run -d -p 8080:8080 --name uber-jar payara-uber-jar --link lasted_mongodb_container_1:mongo


docker images
REPOSITORY                 TAG       IMAGE ID       CREATED             SIZE
payara-uber-jar            latest    53a00d3459c4   About an hour ago   523MB
mongo                      latest    1d3f6d5230f6   2 days ago          696MB
azul/zulu-openjdk-alpine   11        1e4f4d1e64a0   6 days ago          271MB
mongo                      4.0       362f994056cd   2 weeks ago         430MB


docker ps -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS                     PORTS                                           NAMES
02708693ef3d   mongo:latest   "docker-entrypoint.s…"   24 hours ago    Up About a minute          0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   lasted_mongodb_container_1
241700ce3347   mongo:4.0      "docker-entrypoint.s…"   28 hours ago    Exited (0) 24 hours ago                                                    v40_mongodb_container_1


docker run --name servidor_wp -p 80:80 --link lasted_mongodb_container_1:mongo -d wordpress