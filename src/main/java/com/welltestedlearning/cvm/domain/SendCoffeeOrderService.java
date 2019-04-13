package com.welltestedlearning.cvm.domain;

public interface SendCoffeeOrderService {
  long send(CoffeeOrder coffeeOrder);

  String statusFor(Long orderNumber);
}