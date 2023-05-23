package com.falcontech.service;

import com.falcontech.model.Summary;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class DeliveryService {
  @Inject @RestClient OrderService orderService;
  @Inject @RestClient AddressService addressService;

  public CompletionStage<Summary> getDeliverySummary(String id) {
    return orderService.getOrderInfo(id).handleAsync((order,throwable) -> {
      Summary summary = new Summary();
      summary.setOrder(order);
      return summary;
    });
  }
}
