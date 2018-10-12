#!/bin/sh
mvn clean package && docker build -t at.htl.nvs.kneidinger/microprofile .
docker rm -f microprofile || true && docker run -d -p 8080:8080 -p 4848:4848 --name microprofile at.htl.nvs.kneidinger/microprofile