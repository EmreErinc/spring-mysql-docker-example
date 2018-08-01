FROM java:8
VOLUME /temp
ADD target/app.jar app.jar
EXPOSE 6000
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]