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

cd ../storage-spring-adapter && \
  mvn clean package && \
  gcloud functions deploy test-trigger-spring-gen-2 \
    --gen2 \
    --runtime java17 \
    --region=europe-west8 \
    --entry-point=org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
    --set-env-vars=spring_profiles_active=gen2 \
    --source=target/deploy \
    --trigger-event-filters="type=google.cloud.storage.object.v1.finalized" \
    --trigger-event-filters="bucket=${bucketName}"
