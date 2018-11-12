# Ubuntu base image
FROM gcr.io/s4-oncsuite-dev-181912/oncsuite-ms-base
MAINTAINER Arjun Sahasranam

ENV PROFILE $PROFILE

RUN mkdir -p cp-os-datastore/logs

COPY cp-os-datastore/target/cp-os-datastore.jar cp-os-datastore/

ADD cp-os-datastore/start.sh /home/

RUN chmod +x /home/start.sh

EXPOSE 9090

CMD ["sh", "-c", "/home/start.sh -Dspring.profiles.active=$PROFILE cp-os-datastore/cp-os-datastore.jar"]

