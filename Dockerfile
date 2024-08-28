# Docker 镜像构建
 # @author <a href="https://github.com/Aixbox">Aixbox</a>
 # @from <a href="https://www.aixbox.top">Aixbox-blog</a>
 
 #使用java8基础镜像
 FROM openjdk:8-jre
 
 # Copy local code to the container image.
 #把jar包添加到镜像中，并且起一个别名（必须起别名，不然会报错）
 ADD codesandbox-api-0.0.1-SNAPSHOT.jar codesandbox-api.jar
 
 # Build a release artifact.
 #RUN mvn package -DskipTests

 # 将 Docker socket 文件挂载到容器中
VOLUME ["/var/run/docker.sock"]

# 设置环境变量
ENV DOCKER_HOST=unix:///var/run/docker.sock
 
 #暴露项目的端口8080
 EXPOSE 8080
 
 # Run the web service on container startup.
 #镜像运行时运行的命令
 CMD ["java","-jar","codesandbox-api.jar"]