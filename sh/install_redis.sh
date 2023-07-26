#!/usr/bin/env bash

echo '----部署redis开始----'
docker stop redis
docker rm redis
rm -rf /install/redis
mkdir -p /install/redis
docker run --name redis -p 24458:6379 --privileged=true -e TZ="Asia/Shanghai" --restart=always -d -v /etc/localtime:/etc/localtime  -v /install/redis/data:/data  redis:7 redis-server --appendonly yes --requirepass Av*duP#992CBd##wdL&K
echo '----部署redis结束----'










