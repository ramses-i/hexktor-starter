FROM bellsoft/liberica-openjdk-alpine:21

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Install ca-certificates dependency
RUN apk --no-cache upgrade && apk --no-cache add ca-certificates

# Add apiservver user and group
RUN addgroup apiserver && adduser -D -G apiserver apiserver

# Create apiserver directory to run application
RUN mkdir -p /home/apiserver && chown -R apiserver:apiserver /home/apiserver

# Set user to apiserver:apiserver
USER apiserver:apiserver

# Copy apiserver JAR as apiserver user and group
COPY --chown=apiserver:apiserver ./app/infra/build/libs/infra-all.jar /home/apiserver/apiserver.jar

# Set work directory to apiserver
WORKDIR /home/apiserver

# Setup ports
ENV PORT 8080
EXPOSE 8080

# Command to execute compiled app
CMD ["java", "-server", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "apiserver.jar"]
