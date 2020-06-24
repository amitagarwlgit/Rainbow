#!/bin/bash

IFS=$'\n'
set -f 

filename='MachineIP.txt'

for i in $(cat $filename); do
	echo $i
			ssh  amiagarwal@$i \
				'for k in $(ps -ef | grep java | grep -v grep | awk '\''{print $8}'\''); do  \
					if [[ $($k -version 2>&1) == *"OpenJDK"* ]]; \
						then echo "Process ==>"$k" ==> OpenJDK"; \
					elif [[ $($k -version 2>&1) == *"Java(TM)"* ]]; \
						then echo "Process ==>" $k " ==> OracleJDK"; \
					else echo "No Process with JDK found"; fi;  done;'
		
		done;

	echo "I am done"
done


