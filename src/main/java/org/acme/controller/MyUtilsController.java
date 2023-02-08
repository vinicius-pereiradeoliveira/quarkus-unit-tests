package org.acme.controller;

import org.acme.service.MyUtilsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/util")
public class MyUtilsController {

    @Inject
    MyUtilsService utilService;

    @GET
    @Path("/validate/prime/{number}")
    public Response verifyPrimeNumber(@PathParam("number") int number) {

        try {
            return Response.ok(utilService.isPrimeNumber(number)).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Path("/count/{text}")
    public Response verifyTextSize(@PathParam("text") String text) {

        try {
            return Response.ok(utilService.countCharacters(text)).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

}
