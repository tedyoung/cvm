package com.welltestedlearning.cvm.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class StubSendCoffeeOrderService implements SendCoffeeOrderService {

  @Override
  public long send(CoffeeOrder coffeeOrder) {
    return -1;
  }

  @Override
  public String statusFor(Long orderNumber) {
    return "Brewing";
  }
}
