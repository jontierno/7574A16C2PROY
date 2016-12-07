
#Correr la imagen del load balancer


sudo docker run -it --name=prueba jtierno/7574a16c2proy:loadbalancer /bin/bash

Dentro ejecutar

```sh

$ service apache2 start
$ mosquitto -c mosquitto/mosquitto.conf &
$ ./loadbalancer-daemon.sh

```sh