#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-quarkus && \
  ./mvnw clean install && \
  gcloud functions deploy test-trigger-quarkus-gen-2 \
    --gen2 \
    --runtime java17 \
    --memory 128Mi \
    --region=$region \
    --entry-point=io.quarkus.gcp.functions.QuarkusCloudEventsFunction \
    --source=target/deployment \
    --trigger-event-filters="type=google.cloud.storage.object.v1.finalized" \
    --trigger-event-filters="bucket=${bucketName}"
