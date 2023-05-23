package com.falcontech.controller;

import com.falcontech.model.Summary;
import com.falcontech.service.DeliveryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.concurrent.CompletionStage;

@Path("/api/order")
public class Controller {
    @Inject
    DeliveryService deliveryService;

    @GET
    @Path("/{id}")
    public CompletionStage<Summary> getDeliveryInfo(@PathParam("id") String id) {
        return deliveryService.getDeliverySummary(id);
    }
}
