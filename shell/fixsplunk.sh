#!/bin/bash

IFS=$'\n'
set -f 


SERVERIPS=$(aws --region us-west-2  ec2 describe-instances --filters "Name=tag:aws:autoscaling:groupName,Values=fcts-txb-dev-subscriber-scale-11-ASG-U64B12WP4H3B" | grep 'PrivateIpAddress' | awk '{print $2}'  | tr '[' ' ' |  tr '"' ' ' | tr ',' ' ' | tr -d ' ' | sort | uniq |  egrep '[0-9]')


	for j in $SERVERIPS; do
		echo "Trying login on ...";
                echo "MachineIP ==>" $j;
		#ssh -t amiagarwal@$j "sudo chown -R splunk:splunk /opt/splunkforwarder; sudo service splunk restart;"
	done;
