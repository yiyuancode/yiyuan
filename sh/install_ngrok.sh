#!/usr/bin/env bash

echo '----部署redis开始----'
mkdir -p /intsall/ngrok
cd /install/ngrok
wget -qo- http://116.63.167.220:50015/install/nginx/html/install/ng/build.sh
wget -qo- http://116.63.167.220:50015/install/nginx/html/install/ng/docker-compose.yml
wget -qo- http://116.63.167.220:50015/install/nginx/html/install/ng/entrypoint.sh
wget -qo- http://116.63.167.220:50015/install/nginx/html/install/ng/history-zzg.txt
wget -qo- http://116.63.167.220:50015/install/nginx/html/install/ng/history-zzg.txt

docker stop redis
docker rm redis
rm -rf /install/redis
mkdir -p /install/redis
#docker run --name redis -p 40008:6379 --privileged=true -e TZ="Asia/Shanghai" --restart=always -d -v /etc/localtime:/etc/localtime  -v /install/redis/data:/data  redis:7 redis-server --appendonly yes --requirepass "Av*duP#992CBd##wdL&K"
docker run --name redis -p 40008:6379 --privileged=true -e TZ="Asia/Shanghai" --restart=always -d -v /etc/localtime:/etc/localtime  -v /install/redis/data:/data  redis:7 redis-server --appendonly yes

echo '----部署redis结束----'










