#!/bin/bash

microservices=("03_api-gateway" "03_book-service" "03_cambio-service" "03_naming-server")

for microservice in "${microservices[@]}"
do
  echo "Downloading dependencies for the microservice: $microservice"
  cd "$microservice"
  mvn dependency:resolve
  cd ..