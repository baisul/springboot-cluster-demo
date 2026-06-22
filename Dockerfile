FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

# 通配符匹配任何 WAR 包
COPY build/libs/*.war /app/app.jar

RUN mkdir -p /app/logs

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -Duser.timezone=Asia/Shanghai"

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]