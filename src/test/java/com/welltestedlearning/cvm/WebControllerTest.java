package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebControllerTest {
  @Test
  public void postWorks() throws Exception {
    FakeCoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrderWebController coffeeOrderWebController = new CoffeeOrderWebController(coffeeOrderRepository, new StubCurrencyConversionService());
    CoffeeOrderForm form = new CoffeeOrderForm();
    form.setName("Ted");
    form.setSize("LARGE");
    coffeeOrderWebController.processOrderCoffee(form);

    assertThat(coffeeOrderRepository.findAll())
        .hasSize(1);
  }
}