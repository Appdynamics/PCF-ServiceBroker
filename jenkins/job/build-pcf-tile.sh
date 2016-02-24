#!/bin/bash

pushd tile

echo $buildPlatform

# Create Release
./createRelease.sh

# Create Tile
./createTile1.5.sh

popd
