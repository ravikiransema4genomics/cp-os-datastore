#!/bin/bash
	echo $SERVICE_KEY | base64 --decode --ignore-garbage > ${HOME}/gcloud-service-key.json
	sudo /opt/google-cloud-sdk/bin/gcloud --quiet components update
	sudo /opt/google-cloud-sdk/bin/gcloud components install kubectl
	sudo /opt/google-cloud-sdk/bin/gcloud auth activate-service-account --key-file ${HOME}/gcloud-service-key.json
	sudo /opt/google-cloud-sdk/bin/gcloud config set project ${PROJECT_ID}
	sudo /opt/google-cloud-sdk/bin/gcloud container clusters get-credentials $CLUSTER_NAME --zone $CLUSTER_ZONE
	sudo chmod 777 /home/circleci/.kube/config -R
	sudo chown -R $USER /home/circleci/.config

