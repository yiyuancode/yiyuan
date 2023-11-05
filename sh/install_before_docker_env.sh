#!/usr/bin/env bash
#安装docker前环境脚本
echo '----安装dokcer前环境准备开始----'

echo '----查看当前系统内核版本开始----'
uname -r
echo '----查看当前系统内核版本结束----'


echo '----更新yum镜像原开始----'
yum -y update -y
echo '----更新yum镜像原结束----'


echo '----启用 ELRepo 仓库开始----'
rpm --import https://www.elrepo.org/RPM-GPG-KEY-elrepo.org
rpm -Uvh http://www.elrepo.org/elrepo-release-7.0-3.el7.elrepo.noarch.rpm
echo '----启用 ELRepo 仓库结束----'

echo '----查看可用的系统内核包开始----'
yum --disablerepo="*" --enablerepo="elrepo-kernel" list available -y
echo '----查看可用的系统内核包结束----'


echo '----安装最新版本内核开始----'
yum --enablerepo=elrepo-kernel install kernel-ml -y
echo '----安装最新版本内核结束----'

echo '----查看系统上的所有可用内核开始----'
sudo awk -F\' '$1=="menuentry " {print i++ " : " $2}' /etc/grub2.cfg
echo '----查看系统上的所有可用内核结束----'


echo '----设置新的内核为grub2的默认版本开始----'
grub2-set-default 0
echo '----设置新的内核为grub2的默认版本结束----'

echo '----生成 grub 配置文件并重启开始----'
grub2-mkconfig -o /boot/grub2/grub.cfg
reboot
echo '----生成 grub 配置文件并重启结束----'

echo '----安装dokcer前环境准备结束----'


