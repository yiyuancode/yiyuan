#!/usr/bin/env bash
#服务器放开端口20000-20010
echo '----部署mysql5.7开始----'
rm -rf  /install/mysql5.7/
echo '----创建mysql5.7宿主机挂载目录----'
mkdir -p /install/mysql5.7/
docker stop mysql5.7
docker rm mysql5.7
echo '----延迟开始----'
sleep 3s
echo '----延迟结束----'
echo '----拉取mysql5.7镜像创建并运行mysql5.7容器----'
docker run -d -p 23306:3306 --privileged=true  -v /install/mysql5.7/data:/var/lib/mysql -v /install/mysql5.7/conf/my.cnf:/etc/my.cnf  -e MYSQL_ROOT_PASSWORD='123456' --name mysql5.7 mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci
docker rm mysql5.7
echo '----延迟开始----'
sleep 3s
echo '----延迟结束----'
docker run -d -p 23306:3306 --privileged=true  -v /install/mysql5.7/data:/var/lib/mysql -v /install/mysql5.7/conf/my.cnf:/etc/my.cnf  -e MYSQL_ROOT_PASSWORD='123456' --name mysql5.7 mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci
