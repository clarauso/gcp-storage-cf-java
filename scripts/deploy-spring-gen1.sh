#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-spring-adapter && \
  mvn clean package && \
  gcloud functions deploy test-trigger-spring-gen-1 \
    --docker-registry=artifact-registry \
    --runtime java17 \
    --region=$region \
    --entry-point=org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
    --set-env-vars=spring_profiles_active=gen1 \
    --source=target/deploy \
    --trigger-bucket=$bucketName