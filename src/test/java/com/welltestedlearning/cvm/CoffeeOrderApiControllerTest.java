package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderApiControllerTest {
  @Test
  public void testGetMapping() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.size(SizeOption.MEDIUM);
    coffeeOrder.changeNameTo("Ivan");
    coffeeOrder.setId(123L);
    coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrderApiController controller = new CoffeeOrderApiController(coffeeOrderRepository, new StubCurrencyConversionService());

    CoffeeOrderResponse coffeeOrderResponse = controller.coffeeOrderInfo("123", "usd").getBody();

    // medium coffee is 150 cents
    assertThat(coffeeOrderResponse.getPrice())
        .isEqualTo("150");
    assertThat(coffeeOrderResponse.getName())
        .isEqualTo("Ivan");
  }

  @Test
  public void getWithPoundQueryParamConvertsPriceToPounds() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrderApiController controller =
        new CoffeeOrderApiController(coffeeOrderRepository, new StubCurrencyConversionService());

    // When: we do a GET with "gbp" currency
    CoffeeOrderResponse response = controller.coffeeOrderInfo(
        String.valueOf(savedCoffeeOrder.getId()), "gbp").getBody();

    // Then: price will always be 1234
    assertThat(response.getPrice())
        .isEqualTo("1234");
  }
}
