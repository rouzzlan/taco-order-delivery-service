package com.falcontech.service;

import com.falcontech.model.Address;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.concurrent.CompletionStage;

@Path("/address")
@RegisterRestClient(configKey = "address-service")
@Produces(MediaType.APPLICATION_JSON)
public interface AddressService {
    @GET
    @Path("/{hash}")
    CompletionStage<Address> getAddress(@PathParam("hash") String hash);
}
