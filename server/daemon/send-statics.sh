#!/bin/bash


INTERVAL='60s'
BROKER_PORT=1883
BROKER_URL='balancer'
IDUNICO='CAMBIAR'
TOPIC="computadoras/$IDUNICO/carga"

echo "Se intentara enviar las notificaciones a $BROKER_URL:$BROKER_PORT con id $IDUNICO"
while [ true ]
do
    FREEMEM=$(cat /proc/meminfo | grep MemFree | sed -r 's/[^0-9]*([0-9]+)[^0-9]*/\1/g')
    CPULOAD=$(cat /proc/loadavg | cut -f 1 -d' ')
    mosquitto_pub -u publisher --pw publisher -h $BROKER_URL -p $BROKER_PORT -t $TOPIC -m "$FREEMEM;$CPULOAD"
    sleep $INTERVAL
done
