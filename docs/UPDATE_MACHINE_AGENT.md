Update Machine Agent
===================
----------

**Create new machine agent .zip file**
Follow till Step 5 mentioned [here](https://singularity.jira.com/wiki/display/CORE/PCF+-+Machine+Agent+Extension+Configuration) to create new machineagent-bundle-64bit-linux.zip file

**Replace machine agent .zip file**
Replace the old machineagent-bundle-64bit-linux.zip file with the new one
> [root@cent7-npm-perf-01 PCF-ServiceBroker]# mv **path_to_new_.zip_file** .

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
