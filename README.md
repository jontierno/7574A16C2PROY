# Proyecto Sistemas distribuidos.

Para poder iniciar el sistema completo es necesario llevar acabo la siguiente secuencia

  - Iniciar los nodos cocrkoach.
  - Iniciar el servidor DNS.
  - Configurar el dns.
  - Crear los containers server.
  - Crear el container del loadbalancer.
  - Configurar las direcciones ips de los servers en el loadbalancer.
  - Arrancar el loadbalancer.
  - Arrancar el servicio de update  y la aplicación java en los containers server.


### Iniciar los nodos cocrkoachdb

El primer nodo se inicia de la siguiente manera

```sh
$ sudo docker run -d --name=roach1 --hostname=roach1 --net=bridge -p 26257:26257 -p 8080:8080 -v "${PWD}/cockroach-data/roach1:/cockroach/cockroach-data" cockroachdb/cockroach:beta-20161201 start --insecure
```
Es necesario tener en cuenta que el comando es necesario correrlo en una carpeta donde se puedan almacernar los datos de la database ya que usa pwd para relacionar el almacenamiento de la DB.
La ip del container puede chequearse con 

```sh
$ sudo docker inspect roach1
```
Para los siguientes nodos se usa el comando, rootnodeip/name se obtiene con el comando anterior.
```sh
$ sudo docker run -d --name=roach2 --hostname=roach --net=bridge -v "${PWD}/cockroach-data/roach2:/cockroach/cockroach-data" cockroachdb/cockroach:beta-20161201 start --insecure --join={rootnodeip/name}
```
### Iniciar servidor dns

```sh
$ sudo docker run -d --name=bind --volume=/srv/docker/bind:/data   --env='ROOT_PASSWORD=SecretPassword' sameersbn/bind:latest
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
### Configurar las direcciones ips de los servers en el loadbalancer.
### Arrancar el loadbalancer.
### Arrancar el servicio de update  y la aplicación java en los containers server.
