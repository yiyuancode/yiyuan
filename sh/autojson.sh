#!/usr/bin/env bash
#
## 定义要写入的JSON内容
#json_content='{
#  "registry-mirrors": ["http://hub-mirror.c.163.com"]
#}'
#
## 使用sudo命令以root权限执行vi编辑器来创建/编辑文件
#sudo vi /etc/docker/daemon.json <<EOF
#$i${json_content}
#:wq
#EOF



# 清空文件内容
mkdir -p /etc/docker
touch /etc/docker/daemon.json
echo '{
  "registry-mirrors": ["http://hub-mirror.c.163.com"]
}' > /etc/docker/daemon.json

#sudo echo -n > /etc/docker/daemon.json

## 输入JSON内容并写入文件
#json_content='{
#  "registry-mirrors": ["http://hub-mirror.c.163.com"]
#}'
#
#echo "$json_content" | sudo tee -a /etc/docker/daemon.json > /dev/null