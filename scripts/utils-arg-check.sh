#!/bin/bash

while getopts b:r: flag
do
    case "${flag}" in
        b) bucketName=${OPTARG};;
        r) region=${OPTARG};;
        *) exit 22
    esac
done

if [ -z "$bucketName" ]
then
      echo "Set the bucket name using -b option"
      exit 22
fi

if [ -z "$region" ]
then
      echo "Set the cloud region using -r option"
      exit 22
fi