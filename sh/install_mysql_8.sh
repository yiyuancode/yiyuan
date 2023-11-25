#!/usr/bin/env bash
#mysql8搭建教程https://www.jianshu.com/p/e91a6f8b8795
echo '----部署mysql8开始----'
sudo mkdir -p /install/mysql8/conf
cd /install/mysql8/conf
touch my.cnf
echo '[mysql]
#设置mysql客户端默认字符集
default-character-set=utf8mb4
[mysqld]
# 数据库忽略大小写 8.0加了启动报错
# lower_case_table_names = 1
#设置3306端口
port=3306
#允许最大连接数
max_connections=1000
#允许连接失败的次数。
max_connect_errors=10
#最大允许包
max_allowed_packet=10M
#服务端使用的字符集默认为utf8mb4
character-set-server=utf8mb4
collation_server = utf8mb4_general_ci
#创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# mysql8中“mysql_native_password”插件认证不让用了，改成默认的caching_sha2_password
default_authentication_plugin=caching_sha2_password' > /install/mysql8/conf/my.cnf
#配置文件权限不能777，否则报错
sudo docker run -d -p 23306:3306 --restart=always --privileged=true -v /install/mysql8/log:/var/log/mysql -v /install/mysql8/data:/var/lib/mysql -v /install/mysql8/conf/my.cnf:/etc/mysql/my.cnf -v /install/mysql8/mysql-files:/var/lib/mysql-files  -e MYSQL_ROOT_PASSWORD=mysql123  --name mysql8 mysql:8.0.20

#sudo docker exec -it mysql8 /bin/bash
#root@a18abfe70e23:/# mysql8 -u root -p
#mysql> use mysql;
#mysql> select Host, User, plugin, authentication_string from user;
echo '----部署mysql8开始----'