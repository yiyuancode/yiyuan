#!/bin/bash -e

export `cat /tmp/.env|grep -v "^#"`
export -p
export GO111MODULE=off
export GOPROXY=https://goproxy.cn
git clone https://gitee.com/OtherCopy/ngrok.git
cd ngrok
#yum -y install wget
#cd /ngrok/src/ngrok/server/
#rm -rf tunnel.go
#wget -qO- http://116.63.167.220:50015/tunnel.go
#cd /ngrok/src/ngrok/server/
rm -rf  src/ngrok/server/tunnel.go
cp /tmp/tunnel.go src/ngrok/server/
#cd /ngrok


if [[ ${NGROK_TLS_CRT} ]] && [[ ${NGROK_TLS_KEY} ]] && [[ ${NGROK_TLS_CA} ]] && [ -f ${NGROK_TLS_CRT} ] && [ -f ${NGROK_TLS_KEY} ] && [ -f ${NGROK_TLS_CA} ]; 
then
    echo "使用已有证书"
    cp ${NGROK_TLS_CRT} assets/server/tls/snakeoil.crt
    cp ${NGROK_TLS_KEY} assets/server/tls/snakeoil.key
    cp ${NGROK_TLS_CA} assets/client/tls/ngrokroot.crt
else
    echo "使用自签名证书"
    # 为域名生成证书
    openssl genrsa -out rootCA.key 2048
    openssl req -x509 -new -nodes -key rootCA.key -subj "/CN=$NGROK_DOMAIN" -days 5000 -out rootCA.pem
    openssl genrsa -out server.key 2048
    openssl req -new -key server.key -subj "/CN=$NGROK_DOMAIN" -out server.csr
    openssl x509 -req -extfile <(printf "subjectAltName=DNS:$NGROK_DOMAIN,DNS:$NGROK_DOMAIN") -in server.csr -CA rootCA.pem -CAkey rootCA.key -CAcreateserial -out server.crt -days 5000
    # copy生成的证书到指定目录，编译需要
    cp rootCA.pem assets/client/tls/ngrokroot.crt
    cp server.crt assets/server/tls/snakeoil.crt
    cp server.key assets/server/tls/snakeoil.key
fi

# 采用国内gitee镜像，提升编译速度
git clone -- https://gitee.com/mirrors/log4go.git src/github.com/alecthomas/log4go
git clone -- https://gitee.com/ngrok-install/websocket.git src/github.com/gorilla/websocket
git clone -- https://gitee.com/ngrok-install/go-vhost.git src/github.com/inconshreveable/go-vhost
git clone -- https://gitee.com/ngrok-install/mousetrap.git src/github.com/inconshreveable/mousetrap
git clone -- https://gitee.com/ngrok-install/go-bindata.git src/github.com/jteeuwen/go-bindata
git clone -- https://gitee.com/mirrors_addons/osext.git src/github.com/kardianos/osext
git clone -- https://gitee.com/ngrok-install/binarydist.git src/github.com/kr/binarydist
git clone -- https://gitee.com/GoLibs/go-runewidth.git src/github.com/mattn/go-runewidth
git clone -- https://gitee.com/ngrok-install/termbox-go.git src/github.com/nsf/termbox-go
git clone -- https://gitee.com/mirrors/go-metrics.git src/github.com/rcrowley/go-metrics

#linux server
GOOS=linux GOARCH=amd64 make release-server
#linux client
GOOS=linux GOARCH=amd64 make release-client
#window client
GOOS=windows GOARCH=amd64 make release-client