#!/usr/bin/env bash
#mysql8搭建教程https://www.jianshu.com/p/e91a6f8b8795
echo '----部署node环境开始----'
cd /root/
mkdir -p /root/.nvm
tar -zxvf nvm-0.39.3.tar.gz -C /root/.nvm
echo -e '\n#写入nvm环境全局使用nvm配置\nexport NVM_DIR="/root/.nvm/nvm-0.39.3"\n[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" \n[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"\n# This loads nvm' >>  ~/.bashrc
source ~/.bashrc
nvm -v
nvm install 14.17.2
nvm install 18.16.1
nvm use 14.17.2
npm config set registry https://registry.npm.taobao.org/
npm install -g yarn --registry=https://registry.npm.taobao.org
yarn config set registry https://registry.npmmirror.com/
#安装翻译软件
npm install -g node-baidu-translate-pf
fy 你好
echo '----部署node环境结束----'