######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 16.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

#INSTALACION JAVA
RUN apt-get update && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get install -y nano && \
	apt-get install -y dnsutils &&\
	apt-get install -y iputils-ping &&\
    apt-get install -y mosquitto &&\
    apt-get install -y mosquitto-dev &&\
    apt-get install -y mosquitto-clients &&\
    apt-get clean


ENV JAVA_HOME /usr/lib/jvm/java-8-oracle/

RUN echo "networkaddress.cache.ttl=0" >> $JAVA_HOME/jre/lib/security/java.security

#PREPARACION DE LA APLICACION
RUN cd /home && chmod 777 gradlew \
             && chmod 777 daemon/send-statics.sh

RUN cd /home && chmod 777 gradlew
RUN cd /home && ./gradlew assemble

CMD ["bash"]
EXPOSE 9000
WORKDIR /home
