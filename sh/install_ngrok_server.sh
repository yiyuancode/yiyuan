#!/usr/bin/env bash

echo '----部署redis开始----'
#默认从这个目录开始,可以更换目录
mkdir -p /install/ngrok
cd /install/ngrok
#提前拉取centos:7得docker镜像，避免再docker build 构建容器镜像才拉取 那样会比单独提前拉更慢
docker pull centos:7
#给容器内部创建ssl证书使用
mkdir -p ssl/
#构建ngrok服务端镜像
docker build -t ngrok-docker-server .
#运行服务端
docker run -itd --name ngrok-docker-server -p 80:80 -p 443:443 -p 4443:4443 -v /install/ngrok/ssl:/ssl --env-file=.env ngrok-docker-server
#查看服务运行状态
docker ps -a
#将容器内部生成得win客户端和linux客户端全部拷贝出来
mkdir -p /install/ngrok/client/windows
mkdir -p /install/ngrok/client/linux
docker cp ngrok-docker-server:/ngrok/bin/windows_amd64/ngrok.exe /install/ngrok/client/windows
docker cp ngrok-docker-server:/ngrok/bin/ngrok  /install/ngrok/client/linux

echo '----部署redis结束----'










