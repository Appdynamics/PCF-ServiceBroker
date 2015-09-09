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

package com.appdynamics.cloudfoundry.appdservicebroker.catalog;

import com.appdynamics.cloudfoundry.appdservicebroker.CredentialsHolder;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import java.util.Iterator;

import org.json.simple.parser.ParseException;

public final class Service {
     
    private final Catalog catalog;

    private final Object monitor = new Object();

    private volatile UUID id;

    private volatile String name;

    private volatile String description;

    private volatile Boolean bindable;

    private volatile List<String> tags;

    private volatile ServiceMetadata serviceMetadata;

    private volatile List<String> requires;

    private volatile List<Plan> plans;

    private volatile DashboardClient dashboardClient;

    @Autowired
    Service(Catalog catalog) { //, CredentialsHolder credentialsHolder) {
        this.catalog = catalog;
    }

    UUID getId() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Services must specify an id");
            return this.id;
        }
    }
  
    String getName() {
        synchronized (this.monitor) {
            Assert.notNull(this.name, "Services must specify a name");
            return this.name;
        }
    }

    String getDescription() {
        synchronized (this.monitor) {
            Assert.notNull(this.description, "Services must specify a description");
            return this.description;
        }
    }

    Boolean getBindable() {
        synchronized (this.monitor) {
            Assert.notNull(this.bindable);
            return this.bindable;
        }
    }

    List<String> getTags() {
        synchronized (this.monitor) {
            return this.tags;
        }
    }

    @JsonProperty("metadata")
    ServiceMetadata getServiceMetadata() {
        synchronized (this.monitor) {
            return this.serviceMetadata;
        }
    }

    List<String> getRequires() {
        synchronized (this.monitor) {
            return this.requires;
        }
    }

    List<Plan> getPlans() {
        synchronized (this.monitor) {
            return this.plans;
        }
    }

    @JsonProperty("dashboard_client")
    DashboardClient getDashboardClient() {
        synchronized (this.monitor) {
            return this.dashboardClient;
        }
    }

    Catalog and() {
        synchronized (this.monitor) {
            return this.catalog;
        }
    }

    Service id(UUID id) {
        synchronized (this.monitor) {
            this.id = id;
            return this;
        }
    }

    Service name(String name) {
        synchronized (this.monitor) {
            this.name = name;
            return this;
        }
    }

    Service description(String description) {
        synchronized (this.monitor) {
            this.description = description;
            return this;
        }
    }

    Service bindable(Boolean bindable) {
        synchronized (this.monitor) {
            this.bindable = bindable;
            return this;
        }
    }

    Service tags(String... tags) {
        synchronized (this.monitor) {
            if (this.tags == null) {
                this.tags = new ArrayList<>();
            }
            Arrays.stream(tags).forEach(this.tags::add);
            return this;
        }
    }

    ServiceMetadata metadata() {
        synchronized (this.monitor) {
            if (this.serviceMetadata == null) {
                this.serviceMetadata = new ServiceMetadata(this);
            }

            return this.serviceMetadata;
        }
    }

    Service requires(String... requires) {
        synchronized (this.monitor) {
            if (this.requires == null) {
                this.requires = new ArrayList<>();
            }
            Arrays.stream(requires).forEach(this.requires::add);
            return this;
        }
    }

    Plan plan() {
        synchronized (this.monitor) {
            if (this.plans == null) {
                this.plans = new ArrayList<>();
            }

            Plan plan = new Plan(this);
            this.plans.add(plan);
            return plan;
        }
    }

    @PostConstruct
    Service addAllPlans(/*@Value("${appd_plans}")*/ String appd_plans) throws ParseException {

    	@SuppressWarnings("unchecked")
        CredentialsHolder credentialsHolder = CredentialsHolder.getInstance();
        Iterator<String> keySetIterator = credentialsHolder.getPlans().iterator();

        while(keySetIterator.hasNext()){
            String appd_plan_name = keySetIterator.next();
            UUID appd_plan_uuid  = UUIDGenerator.generatePlanID(appd_plan_name);
            String appd_plan_id  = appd_plan_uuid.toString();

            credentialsHolder.mapPlanIdWithName(appd_plan_name, appd_plan_id);

            plan()
                .id(appd_plan_uuid)
                .name(appd_plan_name)
                .description("Service Plan for " + appd_plan_name)
                .metadata()
                    .bullets("JVM Performance analyzer", "Browser End User Monitoring", "Database call response time & throughput",
                        "Performance data API access", "Synthetics Monitoring", "Software Analytics")
                    .displayName(appd_plan_name.toUpperCase())
                    .and()
                .free(true);
        }
        return this;
    }

    DashboardClient dashboardClient() {
        synchronized (this.monitor) {
            this.dashboardClient = new DashboardClient(this);
            return this.dashboardClient;
        }
    }

}
