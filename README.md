AppDynamics Service Broker Tile 
===================
----------

> Pre-requisites:

 1. [Private install](http://docs.pivotal.io/pivotalcf/getstarted/) of PCF
 2. [Ops Manager](https://network.pivotal.io/) and [Ops Metrics Tile](https://network.pivotal.io/)

> Details

This tile once deployed, will create two separate orgs for two different purposes:

 1. **AppDynamicsServiceBroker-service-org**  - This org is used for deploying AppDynamics Service Broker application. Memory requirement = 1024MB
 2. **PCF-OpsMetrics-service-org** - This org is used for deploying AppDynamics Machine Agent with Cloud Foundry extension. Memory requirement  = 2048MB

In totality, this tile would consume ~5GB memory of the underlying PCF platform

> NOTE

  **If using the AppDynamics tile, please ensure that you are using the *latest buildpack* for instrumenting applications using AppDynamics Service Broker Tile** 

> Useful Links

 1. [Video Link For Demo](https://drive.google.com/drive/folders/0B5Y66q8ImLmTNVd1SktXNnNRb0k)
 2. [PCF Field Engineering Demo Slides](https://drive.google.com/drive/folders/0B5Y66q8ImLmTNVd1SktXNnNRb0k)
 3. [CloudNative-4.2.pptx](https://singularity.jira.com/wiki/download/attachments/119144681/CloudNative-4.2.pptx?version=1&modificationDate=1439243356456&api=v2)

> Versioning

AppDynamics Service Broker Tile 4.2.0.0.0 is bundled with 4.2.0.0 Machine Agent for PCF 1.5

| AppDynamics Service Broker Tile Version  | Machine Agent Version | PCF Version  | Java BP Version  | PHP BP Version  |
| ------------- | ------------- | ------------ |------------- | ------------ |
| 4.1.5.2.0  | 4.1.5.2  | 1.5 | 3.3 and above | latest |


> Docs

Check [this](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/README.md) file for detailed documentation

----------
