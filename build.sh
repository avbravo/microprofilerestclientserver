#!/bin/sh

# Build the application project
mvn clean package

# Build the image from the application
docker build -t microprofilerestclientserver .
