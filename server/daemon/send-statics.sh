#!/bin/bash


INTERVAL='90s'
BROKER_URL='172.17.0.2'
BROKER_PORT=1883
TOPIC="computadoras/NUMERO/carga"
while [ true ]
do
    sleep $INTERVAL
    FREEMEM=$(cat /proc/meminfo | grep MemFree | sed -r 's/[^0-9]*([0-9]+)[^0-9]*/\1/g')
    CPULOAD=$(cat /proc/loadavg | cut -f 1 -d' ')
    mosquitto_pub -u publisher --pw publisher -h $BROKER_URL -p $BROKER_PORT -t $TOPIC -m "$FREEMEM;$CPULOAD"
done
