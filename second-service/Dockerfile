FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk17

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

COPY ejb/target/ejb-1.0-SNAPSHOT.jar ${DEPLOYMENT_DIR}
COPY second-service-backend/target/second-service-backend.war ${DEPLOYMENT_DIR}

EXPOSE 9990 8080