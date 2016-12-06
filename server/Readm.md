sudo docker run -it --net=bind --dns={dnsserverip} --name=server jtierno/7574a16c2proy:server /bin/bash
sudo docker exec -it CONTAINER_ID /bin/bash