Update DB Agent
===================
----------

 1. Download the dbagent.zip file from appdynamics downloads page. 
 2. Unzip the dbagent.zip and then run the command

> jar -xvf dbagent.jar

 3. This will create a **META-INF** dir inside the unzipped dbagent folder. This **META-INF** directory is required by cloud-foundry environment to understand where the main class is, and its dependencies.

 4. Zip all the contents of the dbagent directory into dbagent.zip using the command.
>    zip -r dbagent.zip *

**AddBlob Step**

    [root@cent7-npm-perf-01 PCF-ServiceBroker]# cd tile 
    [root@cent7-npm-perf-01 tile]#./addDBAgentBlob.sh ../dbagent.zip appdynamics-db-agent

This will add updated dbagent in **tile/blobs/** directory

**Update version number in .yml file**

    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile 
    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# vim appdynamics-broker-tile-v1.5.yml

grep for previous version number and replace them with new version number in this file.

**Update createRelease.sh script**
If the machine agent is updated, we need to change the version # of the tile as well.

    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile 
    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile# vim createRelease.sh

Make changes to the version number as highlighted in the image and then save the changes
![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/createRelease.png)

**Remove tmp dir**
Remove tmp dir to purge old metadata and releases

    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile$rm -rf tmp/

**Update createTile.sh script**
If the machine agent is updated, we need to change the version # of the tile as well.

    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker# cd tile 
    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile# vim createTile.sh

Make changes to the version number as highlighted in the image and then save the changes
![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/createTile.png)

Now run the createRelease and createTile scripts to create the new tile

    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile#./createRelease.sh
    nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads/PCF-ServiceBroker/tile#./createTile.sh

----------
