#!/bin/bash

docker build --no-cache -t erp1_image .
docker compose -f ./docker-compose.yml -p vinvin up -d

