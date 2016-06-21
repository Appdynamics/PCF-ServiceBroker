#!/bin/sh

TILE_VERSION=v1.1-OpsMgrv1.6-MAv4.1.5.3 # change
TILE_NAME=AppDynamics-Broker
TILE_FILE=`pwd`/appdynamics-broker-tile-v1.6.yml
RELEASE_TARFILE=`pwd`/releases/*/*.tgz

CONTENT_MIGRATIONS=`pwd`/content_migrations
JAVASCRIPT_MIGRATIONS=`pwd`/migrations


#BOSH_STEMCELL_FILE=`cat ${TILE_FILE} | grep "bosh-stemcell" | grep "^ *file:" | awk '{print $2}' `
#BOSH_STEMCELL_LOCATION=https://s3.amazonaws.com/bosh-jenkins-artifacts/bosh-stemcell/vsphere
rm -rf tmp
mkdir -p tmp
pushd tmp
#Dont bundle the stemcell into the .pivotal Tile file as the stemcell must already be available in the Ops Mgr.
mkdir -p metadata releases #stemcells
cp $TILE_FILE metadata
cp $RELEASE_TARFILE releases

cp -r ${CONTENT_MIGRATIONS} .
cp -r ${JAVASCRIPT_MIGRATIONS} .

# Ignore bundling the stemcell as most often the Ops Mgr carries the stemcell.
# If Ops Mgr complains of missing stemcell, change the version specified inside the tile to the one that Ops mgr knows about

#if [ ! -e "stemcells/$BOSH_STEMCELL_FILE" ]; then
#  curl -k $BOSH_STEMCELL_LOCATION/$BOSH_STEMCELL_FILE -o stemcells/$BOSH_STEMCELL_FILE
#fi
zip -r ${TILE_NAME}-${TILE_VERSION}.pivotal metadata releases content_migrations* migrations
mv ${TILE_NAME}-${TILE_VERSION}.pivotal ..
popd
