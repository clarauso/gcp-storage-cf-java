#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-spring-adapter && \
  mvn clean package && \
  gcloud functions deploy test-trigger-spring-gen-2 \
    --gen2 \
    --runtime java17 \
    --region=$region \
    --entry-point=org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
    --set-env-vars=spring_profiles_active=gen2 \
    --source=target/deploy \
    --trigger-event-filters="type=google.cloud.storage.object.v1.finalized" \
    --trigger-event-filters="bucket=${bucketName}"
