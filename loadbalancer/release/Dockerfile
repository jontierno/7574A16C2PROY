######################################################
## Dockerfile para el loadbalancer                  ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 16.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

#INSTALACION JAVA
RUN apt-get update && \
    apt-get install -y mosquitto &&\
    apt-get install -y mosquitto-dev &&\
    apt-get install -y mosquitto-clients &&\
    apt-get install -y nano && \
	apt-get install -y dnsutils &&\
	apt-get install -y iputils-ping &&\
    apt-get install -y apache2 &&\
    apt-get install -y expect &&\
    apt-get clean


RUN cd /etc/apache2/mods-enabled &&\
    ln -s ../mods-available/cgi.load


RUN mv /home/loadbalancer /usr/lib/cgi-bin/inscripciones &&\
    chmod +x /usr/lib/cgi-bin/inscripciones

RUN rm /var/www/html /index.html &&\
    mv /home/index.html /var/www/html/


CMD ["bash"]
WORKDIR /home
