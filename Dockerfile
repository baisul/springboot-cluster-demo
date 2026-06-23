FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 复制所有 WAR 包到 /app/ 目录（以 / 结尾）
COPY build/libs/*.war /app/

# 先删除可能存在的旧 app.jar，再重命名
RUN rm -f /app/app.jar && mv /app/*.war /app/app.jar

RUN mkdir -p /app/logs

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -Duser.timezone=Asia/Shanghai"

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]