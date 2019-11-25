FROM openjdk:11.0.5-jre-stretch
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/* ./app.jar
EXPOSE 8081
CMD ["java","-jar","app.jar"]