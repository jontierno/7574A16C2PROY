######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 14.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

#INSTALACION JAVA
RUN add-apt-repository ppa:webupd8team/java \
            && apt-get update \
            && apt-get install oracle-java8-installer

#PREPARACION DE LA APLICACION
RUN cd /home && chmod 777 gradlew \
             && chmod 777 daemon/send-statics.sh \

CMD ["bash"]
EXPOSE 9000
