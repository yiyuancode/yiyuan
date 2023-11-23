FROM centos:7

COPY tunnel.go /tmp/
COPY build.sh .
COPY ssl/ /ssl/
COPY entrypoint.sh /sbin/entrypoint.sh

RUN yum install -y epel-release
RUN yum install -y golang openssl
RUN yum install -y git
COPY .env /tmp/
RUN chmod +x ./build.sh
RUN ./build.sh
RUN chmod 755 /sbin/entrypoint.sh
ENTRYPOINT ["/sbin/entrypoint.sh"]
