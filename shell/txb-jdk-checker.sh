#!/bin/bash

IFS=$'\n'
set -f 

filename='serviceTagName.txt'
CONTAINER_ID="sudo docker ps | grep -v CONTAINER | awk '{print \$1}'"
DOCKER_JAVA_PROCESS="for k in \\\`ps -ef | grep java | grep -v grep | awk '{print \\\$8}'\\\`; do if [[ \\\$(\\\$k -version 2>&1) == *'OpenJDK'* ]]; then echo 'Process =>'\\\$k' ==> OpenJDK'; elif [[ \\\$(\\\$k -version 2>&1) == *'Java(TM)'* ]]; then echo 'Process ==>'\\\$k ' ==> OracleJDK'; else echo 'No Process with JDK found'; fi;  done;"


for i in $(cat $filename); do
	SERVERIPS=$(aws --region us-west-2  ec2 describe-instances --filters "Name=tag:Name,Values=$i" | grep 'PrivateIpAddress' | awk '{print $2}' | tr '[' ' ' |  tr '"' ' ' | tr ',' ' ' | tr -d ' ' | sort | uniq | egrep '[0-9]')
	for j in $SERVERIPS; do
		echo "Trying login on ..."
		echo "Component ==>" $i "MachineIP ==>" $j
		

		if [[ $i == *"StormSupervisor"*  || $i == *"TxBAdmin"* ]]; then
			ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -t -i /var/lib/jenkins/.ssh/app.pem centos@$j "sudo docker exec -it \`$CONTAINER_ID\` /bin/bash -c \"$DOCKER_JAVA_PROCESS\""
		else 
			ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -t -i /var/lib/jenkins/.ssh/app.pem centos@$j \
				'for k in $(ps -ef | grep java | grep -v grep | awk '\''{print $8}'\''); do  \
					if [[ $($k -version 2>&1) == *"OpenJDK"* ]]; \
						then echo "Process ==>"$k" ==> OpenJDK"; \
					elif [[ $($k -version 2>&1) == *"Java(TM)"* ]]; \
						then echo "Process ==>" $k " ==> OracleJDK"; \
					else echo "No Process with JDK found"; fi;  done;'
		
		fi;
		done;
	done;
	echo "I am done";
done;



