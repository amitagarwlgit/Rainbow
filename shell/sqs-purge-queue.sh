#!/bin/bash

IFS=$'\n'
set -f

environments=(dev dev1 dev2 dev3 dev4 devrec devjayant devprince devvirendra devamit strs)

for i in ${!environments[@]}
  do
    prefix=${environments[i]}"-"
    echo "starting "$prefix
    SQS_QUEUE_URL_LIST=$(aws sqs --region=us-west-2 list-queues --queue-name-prefix=$prefix | grep $prefix | tr '"' ' ' | tr -d '[:space:]' | tr ',' '\n')
    for j in $SQS_QUEUE_URL_LIST; do
       aws sqs purge-queue --region=us-west-2 --queue-url $j
       echo "Queue " $j " is purged";
    done
  done
