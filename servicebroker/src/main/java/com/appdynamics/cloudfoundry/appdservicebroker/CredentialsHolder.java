/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appdynamics.cloudfoundry.appdservicebroker;

import java.util.HashMap;
import java.util.Set;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * A holder for credential information such as the license key
 */
public final class CredentialsHolder {

	private HashMap<String, JSONObject> appd_plans_by_name;
	private HashMap<String, JSONObject> appd_plans_by_id = new HashMap<String, JSONObject>();
	private HashMap<String, Credentials> appd_plans_map = new HashMap<String, Credentials>();

	private static CredentialsHolder theOne = null;
	
	private static final Log log = LogFactory.getLog(CredentialsHolder.class);

	public static CredentialsHolder createInstance(HashMap<String, JSONObject> appd_plans) {
		
		if (theOne == null) {
			theOne = new CredentialsHolder(appd_plans);
		}

		return theOne;
	}

	public static CredentialsHolder getInstance() {
		if (theOne == null)
			theOne = new CredentialsHolder();
		return theOne;
	}

	CredentialsHolder() {
		try {
			HashMap<String, JSONObject> appd_plans_map = (JSONObject) new JSONParser().parse(System.getenv("APPD_PLANS"));
			init(appd_plans_map);
		} catch(ParseException pe) {log.error("Unable to parse the passed content: " + System.getenv("APPD_PLANS")); }
	}

	CredentialsHolder(HashMap<String, JSONObject> appd_plans) {
		init(appd_plans);
	}

	void init(HashMap<String, JSONObject> appd_plans) {
		this.appd_plans_by_name = appd_plans;

		for(String planName: appd_plans.keySet()) {
			
			JSONObject planValue = appd_plans.get(planName);
			log.debug("Plan Name: " + planName + " and associated plan value: " + planValue);
			
			HashMap<String, String> appd_plan_detail = planValue;

			Credentials appdPlanCredentials = new Credentials();

			appdPlanCredentials.setAccessKey(appd_plan_detail.get("account-access-key"));
			appdPlanCredentials.setAccountName(appd_plan_detail.get("account-name"));
			appdPlanCredentials.setControllerHost(appd_plan_detail.get("host-name"));
			appdPlanCredentials.setControllerPort(appd_plan_detail.get("port"));
			appdPlanCredentials.setIsSSLEnabled(appd_plan_detail.get("ssl-enabled"));

			appd_plans_map.put(planName, appdPlanCredentials);
			log.debug("Created appd plan : " + planName + " with credentials content: " + appdPlanCredentials);
		}

	}

	public void mapPlanIdWithName(String plan_name, String plan_id) {
		this.appd_plans_by_id.put(plan_id, this.appd_plans_by_name.get(plan_name));
		log.debug("Plan Name: " + plan_name + " and associated plan id: " + plan_id + " and value is : " + this.appd_plans_by_name.get(plan_name));
	}

	/**
	 * Returns the plan names
	 *
	 * @return the name of the plan
	 */
	public Set<String> getPlans() {
		return appd_plans_by_name.keySet();
	}

	/**
	 * Returns the json credentials
	 *
	 * @param appd_plan the selected plan name
	 *
	 * @return the json string containing the appd plan details
	 */
	public JSONObject getCredentialsByPlanName(String appd_plan) {
		return appd_plans_by_name.get(appd_plan);
	}

	/**
	 * Returns the license key
	 *
	 * @param appd_plan the selected plan ID
	 *
	 * @return the license key
	 */
	public JSONObject getCredentialsByPlanId(String appd_plan) {
		return appd_plans_by_id.get(appd_plan);
	}
}
