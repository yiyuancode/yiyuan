# 该镜像需要依赖的基础镜像
FROM openjdk:11-jre
VOLUME /tmp
# 将当前目录下的jar包复制到docker容器的/目录下
ADD yiyuan-admin/target/yiyuan-admin-1.0-SNAPSHOT.jar   /yiyuan-admin-1.0-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=dev","/yiyuan-admin-1.0-SNAPSHOT.jar"]

EXPOSE 8085
