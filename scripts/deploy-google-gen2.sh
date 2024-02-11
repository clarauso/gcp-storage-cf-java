#!/bin/sh

while getopts b: flag
do
    case "${flag}" in
        b) bucketName=${OPTARG};;
        *) exit 22
    esac
done

if [ -z "$bucketName" ]
then
      echo "Set the bucket name using -b option"
      exit 22
fi

cd ../storage-functions-framework && \
  gcloud functions deploy test-trigger-google-gen-2 \
    --gen2 \
    --runtime java17 \
    --region=europe-west8 \
    --entry-point=io.github.clarauso.storage.fnframework.SecondGenFunction \
    --source=. \
    --trigger-event-filters="type=google.cloud.storage.object.v1.finalized" \
    --trigger-event-filters="bucket=${bucketName}"
