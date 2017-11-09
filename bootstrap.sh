#!/bin/bash
set -ex

pushd servicebroker

mvn clean install

popd
pushd tile

yes y | ./addServiceBrokerBlob.sh ../servicebroker/target/appdynamics-service-broker.jar appdynamics-service-broker
yes n | ./addBlob.sh ../analytics-agent.zip  appdynamics-analytics-agent
yes n | ./addBlob.sh ../analytics-agent.zip appdynamics-analytics-agent
yes n | ./addBlob.sh ../dbagent-4.1.10.0.zip appdynamics-db-agent
yes n | ./addBlob.sh ../dbagent-4.1.8.0.zip appdynamics-db-agent
yes n | ./addBlob.sh ../machineagent-bundle-64bit-linux.zip appdynamics-machine-agent

wget "https://cli.run.pivotal.io/stable?release=linux64-binary&version=6.32.0&source=github-rel" -O ../cf-linux-amd64.tgz
yes n | ./addBlob.sh ../cf-linux-amd64.tgz cf_cli

./createRelease.sh

popd
