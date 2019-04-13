package com.welltestedlearning.cvm.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Profile("prod")
@Service
public class HttpSendCoffeeOrderService implements SendCoffeeOrderService {

  private RestTemplate restTemplate = new RestTemplate();

  @Value("${order.post.uri}")
  private String postOrderUri;

  @Value("${order.get.uri}")
  private String getStatusUri;

  @Override
  public long send(CoffeeOrder coffeeOrder) {
    // * Transform the CoffeeOrder to a SendOrderRequest object
    //   Use the static .from() method on SendOrderRequest that you wrote before
    // * Name the variable orderRequest
    SendOrderRequest orderRequest = SendOrderRequest.from(coffeeOrder);

    // * This will execute the POST operation:
    SentOrderResponse response = restTemplate.postForObject(
        postOrderUri, orderRequest, SentOrderResponse.class);

    // * Extract the orderNumber from the response
    // * Return the orderNumber
    return response.getOrderNumber();
  }

  @Override
  public String statusFor(Long orderNumber) {

    Map<String, Long> uriVariables = new HashMap<>();
    uriVariables.put("orderNumber", orderNumber);

    OrderStatusResponse orderStatusResponse =
        restTemplate.getForObject(getStatusUri, OrderStatusResponse.class, uriVariables);

    return orderStatusResponse.getStatus();
  }
}
