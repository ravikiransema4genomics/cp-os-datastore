#!/bin/bash
source ./config.sh
setup(){
	if [ ! -d "./jdk1.8.0_131" ]; then
	  	  curl -L -b "oraclelicense=a" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz | tar -xzC $BASE_HOME
	fi
	
	if [ ! -d "./apache-maven-3.5.0" ]; then 
	  curl -sL http://35.193.70.114/repository/sema4-releases/org/apache/maven/3.5.0/maven-3.5.0.tar.gz | tar -xzC $BASE_HOME
	fi

	curl -sL http://35.193.70.114/repository/sema4-releases/org/sonarqube/sonar-scanner/3.1.0.1141-linux/sonar-scanner-3.1.0.1141-linux.tar.gz | tar -xzC $BASE_HOME

}

setuppath(){
    export SONARSCANNER_HOME=$BASE_HOME/sonar-scanner-3.1.0.1141-linux
	export SONARSCANNER=$SONARSCANNER_HOME/bin
    export M2_HOME=$BASE_HOME/apache-maven-3.5.0/
	export M2=$M2_HOME/bin
	export JAVA_HOME=$BASE_HOME/jdk1.8.0_131
	export PATH=$PATH:$JAVA_HOME/bin/
	export PATH=$M2:$PATH
    export PATH=$SONARSCANNER:$PATH

	cp settings.xml $BASE_HOME/apache-maven-3.5.0/conf/settings.xml

	echo $PATH
}


build(){
	cd $1
	mvn clean install -DskipTests -Dproject.props.file=./build-helpers/filters/$2-${BUILD_ENV}.properties
}

builddocker() {
    cd ..
	docker build -f cp-os-datastore/Dockerfile -t cp-os-datastore .
}

generateswaggerclientanddeploy(){
	mvn clean install -DskipTests
	cd $BASE_HOME/$1/target/generated-sources/swagger
	mvn clean install -DskipTests
	cd $BASE_HOME/$1
	rm -rf swagger
	mkdir swagger
	cp $BASE_HOME/$1/target/generated-sources/swagger/target/$1-client-*.jar swagger/
	mvn deploy -DskipTests

}

runsonarqubeanalysis(){
	cd $BASE_HOME/$1
	if [ ! -z "$CIRCLE_PULL_REQUEST" -a "$CIRCLE_PULL_REQUEST" != " " ];  then
		mvn sonar:sonar \
		-Dsonar.analysis.mode=preview \
		-Dsonar.github.pullRequest=${CIRCLE_PULL_REQUEST##*/} \
		-Dsonar.github.repository=sema4genomics/$CIRCLE_PROJECT_REPONAME \
		-Dsonar.github.oauth=$SONAR_GITHUB_OATH \
		-Dsonar.login=$SONAR_LOGIN \
		-Dsonar.password=$SONAR_PASS \
		-Dsonar.host.url=$SONARQUBE_HOST_URL 
	fi
}

exportcodeanalysistosonarqube(){
	cd $BASE_HOME/$1
        sonar-scanner -Dsonar.host.url=$SONARQUBE_HOST_URL
}

setup

setuppath

build cp-os-datastore datastore

builddocker

generateswaggerclientanddeploy cp-os-datastore

runsonarqubeanalysis cp-os-datastore

exportcodeanalysistosonarqube cp-os-datastore

