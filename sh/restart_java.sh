#!/usr/bin/env bash




echo '----部署java开始----'
mkdir -p /install/service/yiyuan-admin
cd /install/service/yiyuan-admin
docker stop yiyuan-admin
docker rm yiyuan-admin
docker rmi yiyuan-admin:latest
docker build  -t yiyuan-admin:latest -f Dockerfile  .

#docker run -it -v /宿主机目录:/容器目录 镜像名 宿主机必须执行该命令 echo "Asia/shanghai" > /etc/timezone
docker run -d -p 50003:8080  --privileged=true  -v /install/service/yiyuan-admin/upload:/upload  -v /etc/localtime:/etc/localtime:ro -e TZ=Asia/Shanghai  --name yiyuan-admin --restart always yiyuan-admin:latest
echo '----部署java结束----'




