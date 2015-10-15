Import new tile
===================
----------

We will now import the new **.pivotal** file which is created using [this](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/CREATE_TILE.md) step.

 1. Click on Import Product
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/ImportTile.png)
 2. Hover on **AppDynamics** mentioned in LHS and click on **Add**
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import1.png)   
  
   ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import2.png)
 3.  The orange color of the tile indicates that the tile needs to be configured. Hence double click on the tile to configure it.
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import3.png)
 4. Click on **Service Broker Application** and configure it as shown in the image below to open security groups and enable access of service broker services 
 ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import4.png)
 5. Also configure a new service plan in **Service Broker Application** 
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import5.png)
 6. Now, click on **Save** to save the configuration
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/Import6.png)
 7. Now Configure the Machine Agent Extension and click on **Save** to save the configuration
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/ConfigureMA.png)
 8. Go back to the **installation dashboard**, the color of the tile should be green which indicated the tile is properly configured. Now click on **Apply Changes** to apply the configuration which will create service plans. 
 ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/FinalConfig.png)
 9. Let the installation go through completely
  ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/ApplyFinalChanges.png)
 10. After the changes are successfully applied, we will see this final screen 
 ![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/FinalScreen.png)

Now, we are ready to use the aps-manager to instrument applications with appdynamics service.

----------
