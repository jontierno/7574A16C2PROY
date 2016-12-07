#!/bin/bash


INTERVAL='2s'
BROKER_PORT=1883
TOPIC="computadoras/$1/carga"
while [ true ]
do
    sleep $INTERVAL
    FREEMEM=$(cat /proc/meminfo | grep MemFree | sed -r 's/[^0-9]*([0-9]+)[^0-9]*/\1/g')
    CPULOAD=$(cat /proc/loadavg | cut -f 1 -d' ')
    mosquitto_pub  -h $2 -p $BROKER_PORT -t $TOPIC -m "$FREEMEM;$CPULOAD"
done
