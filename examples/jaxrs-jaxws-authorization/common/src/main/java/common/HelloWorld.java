/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package common;

import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService(targetNamespace = "http://hello.com")
@Path("/")
public interface HelloWorld {

    @GET
    @Produces("text/plain")
    String sayHi(@QueryParam("text") String text);


    @POST
    @Consumes("text/xml")
    @Produces("text/plain")
    String sayHiToUser(User user);


    @GET
    @Produces("text/xml")
    @XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
    Map<Integer, User> getUsers();
    
    @POST
    @Produces("text/xml")
    @Consumes("text/xml")
    @XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
    Map<Integer, User> echoUsers(@XmlJavaTypeAdapter(IntegerUserMapAdapter.class) Map<Integer, User> users);
}
