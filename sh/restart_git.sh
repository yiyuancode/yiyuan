#!/usr/bin/env bash

echo '----部署java开始----'
#mkdir -p /install/yiyuan-admin-dev
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


#cd /install/yiyuan
#git checkout dev1.0.0
#mvn -B clean package -Dmaven.test.skip=true -Dautoconfig.skip
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/
#docker stop yiyuan-admin-dev
#docker rm yiyuan-admin-dev
#
#docker stop yiyuan-admin-dev
#docker rm yiyuan-admin-dev
#
#docker rmi yiyuan-admin-dev:latest
#docker build  -t yiyuan-admin-dev:latest -f Dockerfile-dev  .
echo '----部署java开始----'
cd /install/
docker build  -t git-maven-dev:latest -f Dockerfile-git  .
docker run -it git-maven-dev -v /install:/install
docker run -it --name git-maven-dev --privileged=true -v /install:/install git-maven-dev:latest
#cd /install/

#cd /install/yiyuan
#git checkout dev1.0.0
#mvn -B clean package -Dmaven.test.skip=true -Dautoconfig.skip
#cp yiyuan-admin-1.0-SNAPSHOT.jar /install/yiyuan-app-api-dev/
docker stop yiyuan-admin-dev
docker rm yiyuan-admin-dev

docker stop yiyuan-admin-dev
docker rm yiyuan-admin-dev

docker rmi yiyuan-admin-dev:latest
docker build  -t yiyuan-admin-dev:latest -f Dockerfile-dev  .
#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 50012:8085 --memory=512m --memory-swap=512m --privileged=true  -v /install/service/yiyuan-admin-dev/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-admin-dev --restart always yiyuan-admin-dev:latest

echo '----部署java结束----'