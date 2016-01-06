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

> Downloads

 1. [AppDynamics Tile](https://network.pivotal.io/products/p-appdynamics)

> Versioning

AppDynamics Service Broker Tile 4.2.0.0.0 is bundled with 4.2.0.0 Machine Agent for PCF 1.5

| AppDynamics Service Broker Tile Version  | Machine Agent Version | PCF Version  | Java BP Version  | PHP BP Version  |
| ------------- | ------------- | ------------ |------------- | ------------ |
| 4.1.5.2.0  | 4.1.5.2  | 1.5 | 3.3 and above | latest |


> Docs

Check [this](https://github.com/Appdynamics/PCF-ServiceBroker/blob/master/docs/README.md) file for detailed documentation

----------
