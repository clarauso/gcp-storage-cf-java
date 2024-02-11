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
  gcloud functions deploy test-trigger-google-gen-1 \
    --docker-registry=artifact-registry \
    --runtime java17 \
    --region=europe-west3 \
    --entry-point=io.github.clarauso.storage.fnframework.FirstGenFunction \
    --source=. \
    --trigger-bucket=$bucketName