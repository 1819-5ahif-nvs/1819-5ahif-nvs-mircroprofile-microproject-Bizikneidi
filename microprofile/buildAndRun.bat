@echo off
call mvn clean package
call docker build -t at.htl.nvs.kneidinger/microprofile .
call docker rm -f microprofile
call docker run -d -p 8080:8080 -p 4848:4848 --name microprofile at.htl.nvs.kneidinger/microprofile