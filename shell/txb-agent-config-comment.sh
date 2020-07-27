#!/bin/bash

IFS=$'\n'
set -f 

filename='agentIp.txt'

for ip in $(cat $filename); do
	echo $ip
		ssh $ip2 'sed -i "s/aws s3/#aws s3/" /etc/init.d/txb-agent'
		done;
	echo "I am done"
done


