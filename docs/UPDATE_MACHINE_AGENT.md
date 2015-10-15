Update to latest Machine Agent and Create new tile
===================
----------

**Clone the repository**

> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads$ git clone https://github.com/Appdynamics/PCF-ServiceBroker
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads$ cd PCF-ServiceBroker/

**Replace machine agent .zip file**
Replace the machineagent-bundle-64bit-linux.zip file with the latest machine agent .zip file which contains the binaries of  [CloudfoundryExtension](https://github.com/Appdynamics/cloud-foundry-extension)

**AddBlob Step**

> [root@cent7-npm-perf-01 PCF-ServiceBroker]# cd tile
> [root@cent7-npm-perf-01 tile]#./addBlob.sh
> ../machineagent-bundle-64bit-linux.zip appdynamics-machine-agent

This will add updated machine-agent in **tile/blobs/** directory

**CreateRelease Step**

> [root@cent7-npm-perf-01 tile]#./createRelease.sh

**CreateTile Step**

    [root@cent7-npm-perf-01 tile]#./createTile.sh

Now follow the steps for [deleting old tile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/DELETE_TILE.md) and then [importing new tile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/IMPORT_NEW_TILE.md)

----------
