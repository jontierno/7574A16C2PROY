######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 16.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

#INSTALACION JAVA
RUN apt-get update


#PREPARACION DE LA APLICACION
RUN cd /home && chmod 777 cockroach

CMD ["bash"]
WORKDIR /home

