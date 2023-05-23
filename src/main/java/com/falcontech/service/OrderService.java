package com.falcontech.service;

import com.falcontech.model.Order;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.concurrent.CompletionStage;

@Path("/order")
@RegisterRestClient(configKey = "order-service")
@Produces(MediaType.APPLICATION_JSON)
public interface OrderService {
  @GET
  @Path("/{id}")
  CompletionStage<Order> getOrderInfo(@PathParam("id") String id);
}
