FROM azul/zulu-openjdk-alpine:11

ENV APP_LOCATION target/microprofilerestclientserver-microbundle.jar
ENV APP_NAME application.jar

ADD $APP_LOCATION $APP_NAME
RUN chmod +x $APP_NAME

EXPOSE 8080

ENTRYPOINT java -jar $APP_NAME
#FROM payara/micro
#COPY target/microprofilerestclientserver.war  $DEPLOY_DIR
