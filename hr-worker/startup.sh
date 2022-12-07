#!/bin/bash
# This script is used to start the application

# Alert
clear
echo "Did you compile the application before starting it?"
echo "Remember to compile first with the './mvnw clean install' command"

# Initialize application
echo "Select the port number to start the application"
echo "For example: 8081"
read port
echo "Starting the application on port $port"
java -jar -Dserver.port=$port target/hr-worker-0.0.1-SNAPSHOT.jar
