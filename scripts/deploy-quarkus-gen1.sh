#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-quarkus && \
  ./mvnw clean install && \
  gcloud functions deploy test-trigger-quarkus-gen-1 \
    --docker-registry=artifact-registry \
    --runtime java17 \
    --memory 128MB \
    --region=$region \
    --entry-point=io.quarkus.gcp.functions.QuarkusBackgroundFunction \
    --source=target/deployment \
    --trigger-bucket=$bucketName