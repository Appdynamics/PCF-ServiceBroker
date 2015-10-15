Update .yml file and Create new tile
===================
----------

**Clone the repository**

> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads$ git clone https://github.com/Appdynamics/PCF-ServiceBroker
> nikhil.katre@Nikhils-Mac-Book-Pro:~/Downloads$ cd PCF-ServiceBroker/tile

**Make changes to .yml file**
nikhil.katre@nikhilscbookpro:~/Downloads/PCF-ServiceBroker/tile$ vim appdynamics-broker-tile-v1.5.yml
Make changes to the .yml file and save those changes

**CreateTile Step**
> nikhil.katre@nikhilscbookpro:~/Downloads/PCF-ServiceBroker/tile$./createTile.sh

**Check whether the new tile is created with updated .yml file**
Check whether the new tile is created with updated .yml file by checking their creation timestamps as follows
![Steps to create tile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Update-.yml-file.png)

Now follow the steps for [deleting old tile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/DELETE_TILE.md) and then [importing new tile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/IMPORT_NEW_TILE.md)

----------
