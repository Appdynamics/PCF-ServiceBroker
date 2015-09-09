package com.appdynamics.cloudfoundry.appdservicebroker.catalog;

import java.util.UUID;

public class UUIDGenerator {

    private final static String SEED_UUID       = "eba46a8a-5d36-44aa-88f6-e36b1446a0f6"; // change for the next release
    
    public static UUID generateServiceID() {
		return UUID.nameUUIDFromBytes(SEED_UUID.getBytes());
	}
	
	public static UUID generatePlanID(String plan_name) {
		return UUID.nameUUIDFromBytes((SEED_UUID+plan_name).getBytes());
	}
}
