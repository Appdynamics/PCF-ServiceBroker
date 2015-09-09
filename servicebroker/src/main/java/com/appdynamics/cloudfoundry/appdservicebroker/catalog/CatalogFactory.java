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

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class CatalogFactory {

    @Bean
    //Catalog catalog(@Value("${serviceBroker.serviceId}") String serviceId,
    //                @Value("${serviceBroker.planId}") String planId) throws ParseException{
    Catalog catalog() throws ParseException{
        // @formatter:off
        return new Catalog()
            .service()
                .id(UUIDGenerator.generateServiceID())
                .name("appdynamics")
                .description("See How Your Apps Are Performing")
                .bindable(true)
                .tags("appdynamics", "apm", "mobile real-user monitoring", "browser real-user monitoring", "database monitoring", "server monitoring", "application analytics")
                .metadata()
                    .displayName("AppDynamics")
                    .imageUrl(URI.create("http://pbs.twimg.com/profile_images/618576522677350400/jfkiwN8N_normal.png"))
                    .longDescription("AppDynamics - One platform for unified monitoring, devops collaboration, and application analytics.")
                    .providerDisplayName("AppDynamics Inc.")
                    .documentationUrl(URI.create("https://docs.appdynamics.com"))
                    .supportUrl(URI.create("http://www.appdynamics.com/support/"))
                    .and()
                .addAllPlans(System.getenv("APPD_PLANS"))
                .and();
        // @formatter:on
    }

}
