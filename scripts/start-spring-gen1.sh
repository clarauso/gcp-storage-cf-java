#!/bin/sh

cd ../storage-spring-adapter &&
  mvn function:run -Dspring.profiles.active=gen1