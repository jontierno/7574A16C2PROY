######################################################
## Dockerfile para el uso del Servidor de registros ##
## Basado en Ubuntu 16.04              		        ##
######################################################

# Imagen Ubuntu oficial versión 14.04
FROM java:oracle-java8

MAINTAINER jtierno jtierno

COPY ./ /home

#PREPARACION DE LA APLICACION
RUN cd /home && chmod 777 gradlew \
             && chmod 777 daemon/send-statics.sh \

CMD ["bash"]
EXPOSE 9000
