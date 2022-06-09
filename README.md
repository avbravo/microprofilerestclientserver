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

----------------------------------------------------------
Crear una red

 docker network create mynetwork

Correr mongodb en la misma red
docker ps -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS                     PORTS                                           NAMES
02708693ef3d   mongo:latest   "docker-entrypoint.s…"   24 hours ago    Up About a minute          0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   lasted_mongodb_container_1
241700ce3347   mongo:4.0      "docker-entrypoint.s…"   28 hours ago    Exited (0) 24 hours ago                                                    v40_mongodb_container_1

docker run  -p:27017:27017 -d --network mynetwork --name=mymongo mongo:latest 



Ejecutar applicativo en una misma red

docker run -d -p 8080:8080 --name uber-jar payara-uber-jar --network mynetwork


