
FROM tomcat:11-jdk25-temurin

# Copia a aplicação para o Tomcat
COPY catalogo.war /usr/local/tomcat/webapps/ROOT.war

# Inicia o Tomcat utilizando a porta fornecida pelo Railway
CMD ["sh", "-c", "sed -i \"s/port=\\\"8080\\\"/port=\\\"${PORT:-8080}\\\"/\" /usr/local/tomcat/conf/server.xml && catalina.sh run"]
