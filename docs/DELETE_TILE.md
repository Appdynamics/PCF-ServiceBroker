Delete AppDynamics Tile from Ops-Manager
=================== 
----------
 - Remove the old tile and then click on **Apply Changes**
 
![RemoveOldTile](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/RemoveTile.png)

 - Let the changes completely go through till you get the screen where  
   it mentions **Changes Applied**

![ApplyChanges](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/ApplyChangesOnOpsManager.png)

 - Now, verify that **appdynamics** is removed both from bosh   
   deployments and bosh releases in the ops-manager, to verify this,   
   follow the next step

**SSH into pivotal-ops-manager**

> **[root@cent7-npm-perf-01 PCF-ServiceBroker]# ssh ubuntu@10.0.34.81** ubuntu@10.0.34.81's password: Welcome to Ubuntu 14.04.2 LTS (GNU/Linux
> 3.16.0-45-generic x86_64)
> 
>  Documentation:  https://help.ubuntu.com/ Last login: Tue Sep 29
> 20:44:42 2015 from osxltsdhar.corp.appdynamics.com
> 
> **ubuntu@pivotal-ops-manager:~$ bosh deployments** Acting as user 'director' on 'microbosh-56d69d339e2b073b5c52'
> 
> +--------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | Name                           | Release(s)                         
> | Stemcell(s)                                   | Cloud Config |
> +--------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | cf-1066a95512aedb24c7cf        | cf-autoscaling/13                  
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/3026 | none         | |    
> | cf-mysql/20                              |                          
> |              | |                                | cf/208.7          
> |                                               |              | |    
> | notifications-with-ui/18                 |                          
> |              | |                                |
> push-console-release/console-du-jour-203 |                            
> |              |
> +--------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | p-metrics-29e7e66b0efa769da255 | cf-metrics/33                      
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/2989 | none         |
> +--------------------------------+------------------------------------------+-----------------------------------------------+--------------+
> 
> Deployments total: 2
> 
> **ubuntu@pivotal-ops-manager:~$ bosh deployments**
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | cf-1066a95512aedb24c7cf                 | cf-autoscaling/13         
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/3026 | none         | |    
> | cf-mysql/20                              |                          
> |              | |                                         | cf/208.7 
> |                                               |              | |    
> | notifications-with-ui/18                 |                          
> |              | |                                         |
> push-console-release/console-du-jour-203 |                            
> |              |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | p-metrics-29e7e66b0efa769da255          | cf-metrics/33             
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/2989 | none         |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+

Thus, we have verified that **appdynamcis**  is removed from releases and deployments of bosh

 - **NOTE:**  If the bosh deployments and releases show **appdynamics** in it. Then do the following to delete **appdynamics**

> ubuntu@pivotal-ops-manager:~$ bosh deployments Acting as user
> 'director' on 'microbosh-56d69d339e2b073b5c52'
> 
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | Name                                    | Release(s)                
> | Stemcell(s)                                   | Cloud Config |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | appdynamics-broker-fb1e8e0e21600f9d8fa2 |
> appdynamics_broker/4.2.0.0.0             |
> bosh-vsphere-esxi-ubuntu-trusty-go_agent/3026 | none         |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | cf-1066a95512aedb24c7cf                 | cf-autoscaling/13         
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/3026 | none         | |    
> | cf-mysql/20                              |                          
> |              | |                                         | cf/208.7 
> |                                               |              | |    
> | notifications-with-ui/18                 |                          
> |              | |                                         |
> push-console-release/console-du-jour-203 |                            
> |              |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+ | p-metrics-29e7e66b0efa769da255          | cf-metrics/33             
> | bosh-vsphere-esxi-ubuntu-trusty-go_agent/2989 | none         |
> +-----------------------------------------+------------------------------------------+-----------------------------------------------+--------------+
> 
> Deployments total: 3 ubuntu@pivotal-ops-manager:~$ bosh delete deployment appdynamics-broker-fb1e8e0e21600f9d8fa2

This will delete **appdynamics** from deployments. Now lets delete **appdynamics** from bosh releases.

> ubuntu@pivotal-ops-manager:/var/tempest/workspaces/default/metadata$
> bosh releases Acting as user 'director' on
> 'microbosh-56d69d339e2b073b5c52'
> 
> +-----------------------+----------------------+-------------+ | Name                  | Versions             | Commit Hash |
> +-----------------------+----------------------+-------------+ | appdynamics_broker    | 4.2.0.0.0*           | 205aff3e+   | | cf     
> | 208.7*               | 966e2645+   | | cf-autoscaling        | 13*  
> | 927bc7ed+   | | cf-metrics            | 33*                  |
> c7d12e9e    | | cf-mysql              | 20*                  |
> caa23b3d+   | | notifications-with-ui | 18*                  |
> 490b6446+   | | push-console-release  | console-du-jour-203* |
> d2d31585+   |
> +-----------------------+----------------------+-------------+ (*) Currently deployed (+) Uncommitted changes
> 
> Releases total: 7
> 
> ubuntu@pivotal-ops-manager:/var/tempest/workspaces/default/metadata$
> bosh delete release appdynamics_broker

This will delete **appdynamics** from bosh releases.

 - Now, lets delete the metadata file from metadata directory. This is  
   how the ops-manager application looks which shows AppDynamics before 
   deleting the **appdynamics** metadata file
   
   ![enter image description
   here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/BeforeRefresh.png)

**Go to metadata dir in pivotal ops-manager**

> ubuntu@pivotal-ops-manager:~$cd
> /var/tempest/workspaces/default/metadata
> ubuntu@pivotal-ops-manager:/var/tempest/workspaces/default/metadata ls
> -la total 196 drwxr-xr-x 2 tempest-web tempest-web   4096 Oct 14 21:35 . drwxr-xr-x 7 tempest-web tempest-web   4096 Sep  9 17:22 ..
> -rw------- 1 tempest-web tempest-web  15552 Sep  9 17:24 07a781ebe2a3.yml
> -rw------- 1 tempest-web tempest-web  27005 Oct 15 19:11 2bee14872afc.yml  **<- AppDynamics Metadata File**
> -rw------- 1 tempest-web tempest-web 116532 Aug  6 01:34 50cfd2792e78.yml

Out of these three files, check which of these is for **apppdynamics**

 - **Move the appdynamics metadata file to /tmp/**

> ubuntu@pivotal-ops-manager:/var/tempest/workspaces/default/metadata$
> sudo mv 2bee14872afc.yml /tmp/

 - **Refresh the ops-manager page**

Refresh the ops-manager page. After refreshing, AppDynamics is now removed from the ops-manager application
![enter image description here](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/images/RemovedLeftPanel.png)

Now, we have successfully deleted the old tile from ops-manager application.

----------
