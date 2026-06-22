FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

# 复制所有 WAR 包到 /app/ 目录
COPY build/libs/*.war /app/

# 重命名为 app.jar
RUN mv /app/*.war /app/app.jar

RUN mkdir -p /app/logs

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -Duser.timezone=Asia/Shanghai"

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]