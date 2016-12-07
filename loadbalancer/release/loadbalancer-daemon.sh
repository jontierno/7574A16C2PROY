#!/bin/bash

BROKER_URL=localhost
BROKER_PORT=1883
TOPIC='computadoras/+/carga'
FILE='load.db'

function procesar {
while  IFS='' read -r line || [[ -n "$line" ]]; do
  local TOPIC=$(echo $line | cut -f 1 -d' ')
  grep -v "$TOPIC .*" $FILE > temp
  cp temp $FILE
  #echo $TEMP > $FILE
  echo "$line;$(date +%s)" >> $FILE
done
}

unbuffer mosquitto_sub  -u suscriber --pw suscriber -h $BROKER_URL -p $BROKER_PORT -t $TOPIC -v 2>&1 | procesar

