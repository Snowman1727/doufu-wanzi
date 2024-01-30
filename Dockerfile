# 使用openjdk:17镜像作为基础镜像
FROM openjdk:17

# 将工作目录设置为/doufu-wanzi
WORKDIR /doufu-wanzi

# 挂载/tmp目录作为卷
VOLUME /tmp

# 复制目标路径下的doufu-wanzi-0.0.1-SNAPSHOT.jar文件到/doufu-wanzi目录下
COPY ./target/doufu-wanzi-0.0.1-SNAPSHOT.jar ./doufu-wanzi.jar

# 在/doufu-wanzi.jar文件上创建一个空文件
RUN touch /doufu-wanzi.jar

# 设置ENTRYPOINT，启动java程序并指定-Djava.security.egd=file:/dev/./urandom和-jar参数
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/doufu-wanzi.jar"]
