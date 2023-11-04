#!/usr/bin/env bash

echo '----部署java开始----'
#mkdir -p /install/yiyuan-admin-dev
#cp Dockerfile-dev /install/
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/
cd /install/
docker stop yiyuan-admin-dev
docker rm yiyuan-admin-dev

docker stop yiyuan-admin-dev
docker rm yiyuan-admin-dev

docker rmi yiyuan-admin-dev:latest
docker build  -t yiyuan-admin-dev:latest -f Dockerfile-dev  .
#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 50012:8085 --memory=512m --memory-swap=512m --privileged=true  -v /install/service/yiyuan-admin-dev/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-admin-dev --restart always yiyuan-admin-dev:latest
echo '----部署java结束----'