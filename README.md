AppDynamics Service Broker Tile 
===================

----------


Steps to delete the tile
-------------

 1. Uninstall/Delete the tile.
     ![image](https://github.com/Appdynamics/ServiceBroker-PCF/blob/master/images/PCF1.png)
 2. Wait for the app dynamics section to go through and get removed...
    even if the rest of the steps are still running.
 3. Then run bosh deployments
 4. Make sure bosh does not show appdynamics as still part of deployed
    components. Then run bosh releases
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
