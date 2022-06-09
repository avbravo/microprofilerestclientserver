# Ejecutar

Desde el directorio del archivo pom.xml

mvn clean install


Ejecutar el proyecto

java -jar target/microprofilerestclientserver-microbundle.jar 

## Docker

# ----------------------------
# Imagen desde un war
# ----------------------------
Dockerfile
```
FROM payara/micro

COPY target/myapplication.war $DEPLOY_DIR

```

Generar el build
```
docker build -t myapplication .
```

Ejecutarlo
```
docker run -d -p 8080:8080 --name myapplication myapplication
```
