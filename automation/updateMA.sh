#!/bin/bash
cd ../..
read -p "Specify the machine agent VERSION to be downloaded. Example: 4.1.5.3`echo $'\n> '`" ma_version
url="https://aperture.appdynamics.com/download/prox/download-file/machine/${ma_version}/MachineAgent-${ma_version}.zip"
pushd /tmp
wget $url
cf_extension_github_repo="https://github.com/Appdynamics/cloud-foundry-extension/tree/PCF-Service-Broker"
echo -e $ma_version
