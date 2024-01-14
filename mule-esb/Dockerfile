FROM openjdk:8

ENV MULE_HOME /opt/mule

ENV MULE_VERSION 3.7.0

ENV APP_NAME=hello-example.zip
ENV APP_DOWNLOAD_URL=http://mule-studio-examples.s3.amazonaws.com/ce/${APP_NAME}
ENV APP_PORT=8888

RUN set -x \
        && cd /opt \
        && curl -o mule.zip https://repository.mulesoft.org/nexus/content/repositories/releases/org/mule/distributions/mule-standalone/$MULE_VERSION/mule-standalone-$MULE_VERSION.zip \
        && unzip mule.zip \
        && mv mule-standalone-$MULE_VERSION mule \
        && rm mule.zip*
RUN wget ${APP_DOWNLOAD_URL} && \
    cp ${APP_NAME} $MULE_HOME/apps && \
    rm  ${APP_NAME}

WORKDIR $MULE_HOME

VOLUME $MULE_HOME/apps
VOLUME $MULE_HOME/conf
VOLUME $MULE_HOME/domains
VOLUME $MULE_HOME/logs

ENTRYPOINT ["./bin/mule"]

# Default http port
EXPOSE 8081
# JMX port.
EXPOSE 1099
#EXPOSE APP PORT
EXPOSE ${APP_PORT}