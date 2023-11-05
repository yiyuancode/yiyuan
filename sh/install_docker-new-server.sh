#!/usr/bin/env bash
#安装docker脚本
echo '----安装docker准备开始----'

echo '----安装docker开始----'
#yum  install docker -y
curl -fsSL https://get.docker.com/ | sh
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




echo '----安装docker准备结束----'
echo '----安装docker-compose准备开始----'
cd /install/
mv docker-compose-linux-x86_64 /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
#linux快捷方式 任意地方都可以启动
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
docker-compose --version
echo '----安装docker-compose准备结束----'



echo '----安装elk准备开始----'
#40000-40006 elk占用端口 40003-40006logstash  40002kibana
cd /install/
tar -zxvf elk.tar.gz
cd /install/elk
#一定要给宿主机挂在目录授权很关键，要不然容器启动会报错java.nio.file.AccessDeniedException: /usr/share/elasticsearch/data/nodes
chmod 777 /install/elk/elasticsearch/data
docker-compose up -d
echo '----安装elk准备结束----'


echo '----部署mysql5.7开始----'
cd /install/
tar -zxvf mysql5.7.tar.gz
docker stop mysql5.7
docker rm mysql5.7
docker rmi mysql:5.7
sleep 3s
docker run -d -p 40007:3306 --privileged=true  -v /install/mysql5.7/data:/var/lib/mysql -v /install/mysql5.7/conf/my.cnf:/etc/my.cnf  -e MYSQL_ROOT_PASSWORD='123456' --name mysql5.7 mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci
echo '----部署mysql5.7结束----'


echo '----部署redis开始----'
cd /install/
tar -zxvf redis.tar.gz
docker stop redis
docker rm redis
docker rmi redis:7
sleep 3s
docker run --name redis -p 40008:6379 --privileged=true -e TZ="Asia/Shanghai" --restart=always -d -v /etc/localtime:/etc/localtime  -v /install/redis/data:/data  redis:7 redis-server --appendonly yes
echo '----部署redis结束----'


echo '----部署minio开始----'
cd /install/
tar -zxvf minio.tar.gz
docker stop minio
docker rm minio
docker rmi quay.io/minio/minio
sleep 3s
docker run -p 40009:9000   -p 40010:9001    --name minio  -d --privileged=true -v /etc/localtime:/etc/localtime  --restart=always  -e TZ="Asia/Shanghai"       -v /install/minio/data:/data  -e "MINIO_ROOT_USER=admin"  -e "MINIO_ROOT_PASSWORD=123/456/789"   quay.io/minio/minio server /data --console-address ":9001"
echo '----部署minio开始----'





