#!/usr/bin/env bash

#echo '----部署java开始----'
#mkdir -p /install/yiyuan-tenant-api-dev
#cp Dockerfile-yiyuan-tenant-api-dev /install/yiyuan-tenant-api-dev/
#cp yiyuan-app-1.0-SNAPSHOT.jar /install/yiyuan-tenant-api-dev/
#
#cd /install/yiyuan-tenant-api-dev
#docker stop yiyuan-tenant-api-dev
#docker rm yiyuan-tenant-api-dev
#
#docker stop yiyuan-tenant-api-dev
#docker rm yiyuan-tenant-api-dev
#
#docker rmi yiyuan-tenant-api-dev:latest
#docker build  -t yiyuan-tenant-api-dev:latest -f Dockerfile-yiyuan-tenant-api-dev  .
##docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
#docker run -d -p 40011:8087 --memory=512m --memory-swap=512m  --privileged=true  -v /install/yiyuan-tenant-api-dev/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-tenant-api-dev --restart always yiyuan-tenant-api-dev:latest
#echo '----部署java结束----'


cd /install/

#cd /install/yiyuan
#git checkout dev1.0.0
#mvn -B clean package -Dmaven.test.skip=true -Dautoconfig.skip
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-tenant-api-dev/
docker stop yiyuan-tenant-api-dev
docker rm yiyuan-tenant-api-dev

docker stop yiyuan-tenant-api-dev
docker rm yiyuan-tenant-api-dev

docker rmi yiyuan-tenant-api-dev:latest
docker build  -t yiyuan-tenant-api-dev:latest -f Dockerfile-dev  .
#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 50014:8086 --memory=512m --memory-swap=512m --privileged=true  -v /install/service/yiyuan-tenant-api-dev/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-tenant-api-dev --restart always yiyuan-tenant-api-dev:latest
echo '----部署java结束----'