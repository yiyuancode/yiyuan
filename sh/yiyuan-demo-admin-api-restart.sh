#!/usr/bin/env bash

echo '----部署java开始----'
#mkdir -p /install/yiyuan-demo-admin-api
#cp Dockerfile-dev /install/
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/
#安装jdk11
#sudo yum install java-11-openjdk-devel
#安装maven
#sudo yum install maven
#mvn -version
#java -version
#安装git
#sudo yum install git

cd /install/yiyuan-demo
#cd /install/yiyuan
#git checkout dev1.0.0
#mvn -B clean package -Dmaven.test.skip=true -Dautoconfig.skip
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/
docker stop yiyuan-demo-admin-api
docker rm yiyuan-demo-admin-api

docker stop yiyuan-demo-admin-api
docker rm yiyuan-demo-admin-api

docker rmi yiyuan-demo-admin-api:latest
docker build  -t yiyuan-demo-admin-api:latest -f yiyuan-demo-admin-api-Dockerfile  .
#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 50015:8085 --memory=512m --memory-swap=512m --privileged=true  -v /install/service/yiyuan-demo-admin-api/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-demo-admin-api --restart always yiyuan-demo-admin-api:latest
echo '----部署java结束----'