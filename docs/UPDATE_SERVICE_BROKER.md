Update Service Broker
===================
----------

**Pre-requisites**
> Java 1.8

**Change path to 'servicebroker' directory**
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads$ cd PCF-ServiceBroker/servicebroker

**Make Code Changes**
Make changes to the code in servicebroker directory

**Build Step**
Go to top-level service-broker directory and build the updated code using maven
> [root@cent7-npm-perf-01 servicebroker]#mvn clean install

**Add the new ServiceBroker**
> [root@cent7-npm-perf-01 servicebroker]#cd ../tile
> [root@cent7-npm-perf-01 tile]#./addServiceBrokerBlob.sh ../servicebroker/target/appdynamics-service-broker.jar appdynamics-service-broker

**Create new Release and Tile**
> [root@cent7-npm-perf-01 tile]#./createRelease.sh
> [root@cent7-npm-perf-01 tile]#./createTile.1.5.sh

----------
