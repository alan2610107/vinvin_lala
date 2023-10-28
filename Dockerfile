FROM tomcat:9.0.82
LABEL authors="alan"

COPY erp.war /usr/local/tomcat/webapps/
EXPOSE 8080

CMD ["catalina.sh", "run"]
