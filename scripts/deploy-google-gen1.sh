#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-functions-framework && \
  gcloud functions deploy test-trigger-google-gen-1 \
    --docker-registry=artifact-registry \
    --runtime java17 \
    --region=$region \
    --entry-point=io.github.clarauso.storage.fnframework.FirstGenFunction \
    --source=. \
    --trigger-bucket=$bucketName