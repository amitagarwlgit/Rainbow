#!/bin/bash

IFS=$'\n'
set -f 

filename='DC2.txt'

for i in $(cat $filename); do
	echo $i
			ssh  amiagarwal@$i 'df -h | grep "/data"'
		done;
	echo "I am done"
done


