#!/bin/bash

source $(dirname "$0")/utils-arg-check.sh "$@"

cd ../storage-functions-framework && \
  gcloud functions deploy test-trigger-google-gen-2 \
    --gen2 \
    --runtime java17 \
    --region=$region \
    --entry-point=io.github.clarauso.storage.fnframework.SecondGenFunction \
    --source=. \
    --trigger-event-filters="type=google.cloud.storage.object.v1.finalized" \
    --trigger-event-filters="bucket=${bucketName}"
