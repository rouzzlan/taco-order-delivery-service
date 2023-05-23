package com.falcontech.service;

import com.falcontech.model.Order;
import com.falcontech.model.Summary;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class DeliveryService {
  @Inject @RestClient OrderService orderService;
  @Inject @RestClient AddressService addressService;

  public CompletionStage<Summary> getDeliverySummary(String id) {
    CompletionStage<Order> orderCS = orderService.getOrderInfo(id);
    return orderCS
        .handleAsync(
            (order, throwable) -> {
              Summary summary = new Summary();
              summary.setOrder(order);
              return summary;
            }).thenComposeAsync(this::getAddress);
  }

  private CompletionStage<Summary> getAddress(Summary summary) {
    return addressService.getAddress(summary.getOrder().addrRef()).handleAsync((address,throwable) -> {
      summary.setAddress(address);
      return summary;
    });
  }
}
