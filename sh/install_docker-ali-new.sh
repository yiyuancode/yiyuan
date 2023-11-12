#!/usr/bin/env bash
#安装docker脚本
echo '----安装docker准备开始----'

echo '----安装docker开始----'
#yum  install docker -y
sudo yum -y remove docker docker-client docker-client-latest docker-common docker-latest docker-latest-logrotate docker-logrotate docker-engine
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
yum -y makecache fast
sudo yum -y install docker-ce docker-ce-cli containerd.io
echo '----安装docker结束----'

echo '----查看docker版本开始----'
docker --version
echo '----查看docker版本结束----'


echo '----更改docker 国内镜像原版本开始----'

#mkdir docker
mkdir -p /etc/docker
chmod -R 777 /etc/docker
touch /etc/docker/daemon.json
echo '{
  "registry-mirrors": ["http://hub-mirror.c.163.com"]
}' > /etc/docker/daemon.json

systemctl restart docker.service
echo '----更改docker 国内镜像原版本结束----'

echo '----设置docker 开机启动开始----'
systemctl start docker
systemctl enable docker
#这行不需要
#yum install -y yum-utils >   device-mapper-persistent-data >   lvm2
systemctl enable docker
echo '----设置docker 开机启动结束----'







