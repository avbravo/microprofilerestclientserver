# Ejecutar

Desde el directorio del archivo pom.xml
```
mvn clean install
```

Ejecutar el proyecto
```
java -jar target/microprofilerestclientserver-microbundle.jar 
```

## Docker

# ----------------------------
# Imagen desde un war
# ----------------------------
Build de la imagen
```
docker build -t payara-uber-jar .
```

## Ejecutar
```
docker run -d -p 8080:8080 --name uber-jar payara-uber-jar
```
# ----------------------------------------------------------
# Crear una red
#
```
 docker network create mynetwork
```
Correr mongodb en la misma red
```
docker ps -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS                     PORTS                                           NAMES
02708693ef3d   mongo:latest   "docker-entrypoint.s…"   24 hours ago    Up About a minute          0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   lasted_mongodb_container_1
241700ce3347   mongo:4.0      "docker-entrypoint.s…"   28 hours ago    Exited (0) 24 hours ago                                                    v40_mongodb_container_1
```
Ejecutar
```
docker run  -p:27017:27017 -d --network mynetwork --name=mymongo mongo:latest 
```


Ejecutar applicativo en una misma red
```
docker run -d -p 8080:8080 --name uber-jar payara-uber-jar --network mynetwork
```

# subirlo a docker-hub

Login docker
```
docker login
```
renombrar la imagen a username/imagen:version
```
docker tag payara-uber-jar avbravo/payara-uber-jar:v1 
```

subir la imagen
```
docker push avbravo/payara-uber-jar:v1
```

Ingresar al sitio de docker hub aparece la imagen publicada

<imagen>

# Borrar las imagenes locales

# Instalar desde docker-hub
```
docker run -p 8080:8080 avbravo/payara-uber-jar:v1
```
# ingresar al navegador
Openapi
```
http://localhost:8080/openapi
```
province
```
http://localhost:8080/api/province/findall
```

Kubernetes
https://blog.payara.fish/scaling-payara-micro-applications-with-kubernetes
https://microprofile.io/2021/09/01/videotutoriales-recorriendo-microprofile-en-espanol/