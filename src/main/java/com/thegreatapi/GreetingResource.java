package com.thegreatapi;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Tester")
    @Path("hello_tester")
    public String helloTester() {
        return "Hello Tester";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    @Path("hello_everyone")
    public String helloUnsecure() {
        return "Hello everyone";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @DenyAll
    @Path("hello_nobody")
    public String helloNobody() {
        return "Hello nobody";
    }
}