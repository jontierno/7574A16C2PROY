####################################################
## Dockerfile para el uso del Application Server  ##
## Basado en Ubuntu 15.10              		  ##
####################################################

# Imagen Ubuntu oficial versión 14.04
FROM ubuntu:16.04

MAINTAINER jtierno jtierno

COPY ./ /home

RUN cd /home/server && chmod 777 gradlew
RUN cd /home/server && ./gradlew bootRun &
CMD ["bash"]
EXPOSE 9000
