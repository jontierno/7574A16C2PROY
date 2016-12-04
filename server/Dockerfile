######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 14.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home
RUN cd /home && chmod 777 gradlew
RUN cd /home/daemon && chmod 777 send-statics.sh
CMD ["bash"]
EXPOSE 9000
