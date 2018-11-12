#!/usr/bin/env bash
curl -sL https://raw.githubusercontent.com/kubernetes/helm/master/scripts/get > ~/helm-install.sh
chmod +x ~/helm-install.sh
~/./helm-install.sh
helm init --service-account tiller
helm repo add oncsuite-repo https://oncsuite-helm-charts.storage.googleapis.com
cd ${HOME}/build/$CIRCLE_PROJECT_REPONAME/helm/
helm dependency update
helm upgrade --install $CIRCLE_PROJECT_REPONAME -f /home/circleci/build/$CIRCLE_PROJECT_REPONAME/helm/$1-values.yaml --set oncsuite-svc.image.tag=$CIRCLE_SHA1 /home/circleci/build/$CIRCLE_PROJECT_REPONAME/helm
