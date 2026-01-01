<<<<<<< HEAD
#FROM tomcat:8.0.20-jre8
FROM tomcat:9.0-jdk17
# Dummy text to test 
COPY target/java-web-app*.war /usr/local/tomcat/webapps/java-web-app.war
=======
FROM tomcat:9.0-jdk17

RUN rm -rf /usr/local/tomcat/webapps/*
# Dummy text to test 
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]

>>>>>>> 8273202 (Add automatic employee every 30s)
