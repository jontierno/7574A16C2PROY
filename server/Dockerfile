######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 14.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

#INSTALACION JAVA
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean

RUN apt-get install -y vim && \
    apt-get clean


ENV JAVA_HOME /usr/lib/jvm/java-8-oracle/

#PREPARACION DE LA APLICACION
RUN cd /home && chmod 777 gradlew \
             && chmod 777 daemon/send-statics.sh

RUN cd /home && chmod 777 gradlew && ./gradlew assemble

CMD ["bash"]
EXPOSE 9000
