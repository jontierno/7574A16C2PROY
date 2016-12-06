
#Correr el servidor dns (bindeando a una ip)
sudo docker run -d --name=bind --publish=172.17.0.1:53:53/udp --publish=172.17.0.1:10000:10000   --volume=/srv/docker/bind:/data   --env='ROOT_PASSWORD=SecretPassword'   sameersbn/bind:latest

Luego es necesario configurar webmin

-Crear una zona distribuidos.com (main server: ip del dns)
-Agregar un registro a "ns": del dns
-Agregar un registro a "dtabase" por cada nodo con cockroach.