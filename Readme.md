# Proyecto Sistemas distribuidos.

Para poder iniciar el sistema completo es necesario llevar acabo la siguiente secuencia

  - Crear una red bridge.
  - Iniciar los nodos cocrkoach.
  - Iniciar el servidor DNS.
  - Configurar el dns.
  - Crear los containers server.
  - Crear el container del loadbalancer.
  - Arrancar el servicio de statics  y la aplicación java en los containers server.
  - Configurar las direcciones ips de los servers en el loadbalancer.

### Crear una red bride
Esto es en el caso de correr todos en una misma máquina.
```sh
$ sudo docker network create -d bridge dist
```
### Iniciar los nodos cocrkoachdb

El primer nodo se inicia de la siguiente manera

```sh
$ sudo docker run -d --name=roach1 --hostname=roach1 --net=dist -p 26257:26257 -p 8080:8080 -v "${PWD}/cockroach-data/roach1:/cockroach/cockroach-data" cockroachdb/cockroach:beta-20161201 start --insecure
```
Es necesario tener en cuenta que el comando es necesario correrlo en una carpeta donde se puedan almacernar los datos de la database ya que usa pwd para relacionar el almacenamiento de la DB.
La ip del container puede chequearse con 

```sh
$ sudo docker inspect roach1
```
Para los siguientes nodos se usa el comando, rootnodeip/name se obtiene con el comando anterior.
```sh
$ sudo docker run -d --name=roach2 --hostname=roach2 --net=dist -v "${PWD}/cockroach-data/roach2:/cockroach/cockroach-data" cockroachdb/cockroach:beta-20161201 start --insecure --join={rootnodeip/name}
```
### Iniciar servidor dns

```sh
$ sudo docker run -d --name=bind --net=dist --volume=/srv/docker/bind:/data   --env='ROOT_PASSWORD=SecretPassword' sameersbn/bind:latest
```
Es importante tener acceso al directorio */srv/docer/bind* o modificarlo a uno que sí sea accesible, es necesario obtener la dirección de este container.

### Configurar servidor dns

Con la dirección ip del container y un navegador acceder al puerto 10000. Usuario *root* y password *SecretPassword*

Ingresar al apartado *Servers -> BIND DNS Server*, y aquí hay que hacer las siguientes acciones:
- Setup RNDC
- Crear una master zone "distribuidos.com" y con la ip del DNS server.
- Agregar tantos adress como nodos cockroach haya y cada uno apuntando a uno nodo distinto, el servidor dns hará el round-robin.
- Aplicar al configuración.

### Crear el container del loadbalancer

Primero es necesario correr la imágen del balancer
```sh
$ sudo docker run -it --name=balancer --hostname=balancer --net=dist jtierno/7574a16c2proy:balancer /bin/bash
```
Una vez en el shell de este container es necesario editar el archivo *mosquitto/config* y editar la linea 
```
listener 1883 172.17.0.2
```
cambiando por la ip del container actual.

A continuación es necesario inicar los servicios de este container.
```sh
$ service apache2 start
$ mosquitto -c mosquitto/config &
$ ./loadbalancer-daemon.sh &
```
### Arrancar el servicio de statics  y la aplicación java en los containers server.

Crear el container de la aplicación java

```sh
$ sudo docker run -it --net=dist --dns={dnsserverip} --name=server --hostname=server jtierno/7574a16c2proy:server /bin/bash
```
Donde *dnsserverip* es la dirección ip del container del servidor dns ademas es necesario setear un name y un hostname únicos

Es necesario indicar un identificador único para cada servidor java (numerico o string) y editar el archivo *daemon/send-statics.sh* para setear ese identificador junto con la dirección ip del container del loadbalancer.
```
BROKER_URL='172.17.0.2'
IDUNICO='NUMERO'
```
Y luego hay que correr los procesos de este container

```sh
$ ./daemon/send-statics.sh &
$ ./gradlew bootRun &
IDUNICO='NUMERO'
```

### Configurar las direcciones ips de los servers en el loadbalancer.

El último paso es editar el archivo *workers.db* en el loadbalancer para setear las direcciones correspondientes a cada uno de los containers server, un ejemplo sería:

```
1=172.17.0.6:9000
2=172.17.0.7:9000
```

