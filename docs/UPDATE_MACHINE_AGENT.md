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

**Update version number in .yml file**
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# vim appdynamics-broker-tile-v1.5.yml

grep for previous version number and replace them with new version number in this file.

**Update createRelease.sh script**
If the machine agent is updated, we need to change the version # of the tile as well.

> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile# vim createRelease.sh

Make changes to the version number as highlighted in the image and then save the changes
![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/createRelease.png)

**Remove tmp dir**
Remove tmp dir to purge old metadata and releases
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile$rm -rf tmp/

**Update createTile.sh script**
If the machine agent is updated, we need to change the version # of the tile as well.
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile# vim createTile.sh

Make changes to the version number as highlighted in the image and then save the changes
![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/createTile.png)

Now run the createRelease and createTile scripts to create the new tile

----------
