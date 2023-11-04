#!/usr/bin/env bash

echo '----部署java开始----'
mkdir -p /install/yiyuan-app-api-dev
cp Dockerfile-yiyuan-app-api-dev /install/yiyuan-app-api-dev/
cp yiyuan-app-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/

cd /install/yiyuan-app-api-dev
docker stop yiyuan-app-api-dev
docker rm yiyuan-app-api-dev

docker stop yiyuan-app-api-dev
docker rm yiyuan-app-api-dev

docker rmi yiyuan-app-api-dev:latest
docker build  -t yiyuan-app-api-dev:latest -f Dockerfile-yiyuan-app-api-dev  .
#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 40011:8087 --memory=512m --memory-swap=512m  --privileged=true  -v /install/yiyuan-app-api-dev/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-app-api-dev --restart always yiyuan-app-api-dev:latest
echo '----部署java结束----'