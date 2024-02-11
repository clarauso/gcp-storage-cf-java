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
  gcloud functions deploy test-trigger-spring-gen-1 \
    --docker-registry=artifact-registry \
    --runtime java17 \
    --region=europe-west3 \
    --entry-point=org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
    --set-env-vars=spring_profiles_active=gen1 \
    --source=target/deploy \
    --trigger-bucket=$bucketName