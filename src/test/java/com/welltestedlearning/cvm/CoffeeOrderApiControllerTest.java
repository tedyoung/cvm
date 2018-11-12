package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderApiControllerTest {
  @Test
  public void testGetMapping() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.size(SizeOption.MEDIUM);
    coffeeOrder.setId(123L);
    coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrderApiController controller = new CoffeeOrderApiController(coffeeOrderRepository);

    CoffeeOrderResponse coffeeOrderResponse = controller.coffeeOrderInfo("123").getBody();

    // medium coffee is 150 cents
    assertThat(coffeeOrderResponse.getPrice())
        .isEqualTo("150");
  }
}
