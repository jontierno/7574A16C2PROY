#Database

Correr el nodo root de la base de datos.


##Iniciar en bridge haciendo binding de los puertps
docker run -d --name=roach1 --hostname=roach1 --net=bridge -p 26257:26257 -p 8080:8080 -v "${PWD}/cockroach-data/roach1:/cockroach/cockroach-data" ockroachdb/cockroach:beta-20161201 start --insecure

##Iniciar directamente como el host.
docker run -d --name=roach1 --hostname=roach1 --net=host -v "${PWD}/cockroach-data/roach1:/cockroach/cockroach-data" ockroachdb/cockroach:beta-20161201 start --insecure


## El resto de los nodos se encienden de la siguiente manera (en modo host)
docker run -d --name=roach2 --hostname=roach --net=host -v "${PWD}/cockroach-data/roach:/cockroach/cockroach-data" cockroachdb/cockroach:beta-20161201 start --insecure --join={rootnodeip/name}