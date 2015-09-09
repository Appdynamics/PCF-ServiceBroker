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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * A holder for credential information such as the account access key
 */
public final class Credentials {

	private String accountName;
	private String accessKey;
	private String controllerHost;
	private String controllerPort;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getControllerHost() {
		return controllerHost;
	}

	public void setControllerHost(String controllerHost) {
		this.controllerHost = controllerHost;
	}

	public String getControllerPort() {
		return controllerPort;
	}

	public void setControllerPort(String controllerPort) {
		this.controllerPort = controllerPort;
	}

	public String getIsSSLEnabled() {
		return isSSLEnabled;
	}

	public void setIsSSLEnabled(String isSSLEnabled) {
		this.isSSLEnabled = isSSLEnabled;
	}

	private String isSSLEnabled;

}
