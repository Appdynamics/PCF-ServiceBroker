AppDynamics Service Broker Tile 
===================
Version of the Machine Agent packaged with the SB tile: Machine Agent v4.1.2.2 GA
----------


Steps to delete the tile
-------------

 1. Delete the tile(garbage icon) and then click on **Apply Changes**
      
     ![image](https://github.com/Appdynamics/ServiceBroker-PCF/blob/master/images/PCF1.png)
      
      Wait till the entire process of **Applying Changes** goes through
 3. Run `bosh deployments`
    Make sure bosh does not show appdynamics as still part of deployed
    components. 
     If it still shows up as part of deployment, then do the following
     
    Then run bosh releases
 5. Then run bosh delete release <appD-release-name>
 6. Wait for Ops Mgr to complete the full cleanup
 7. Then remove the metadata file for appd from
    /var/tempest/default/workspaces/metadata/ directory
 8. Then reinstall the tile


----------


 Steps to bundle latest machine agent
-------------------


----------


Steps to make changes to service broker code
-------------




----------


Steps to create the tile
--------------------




----------
