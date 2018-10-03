package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderTest {

  @Test
  public void emptyOrderIs0() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    assertThat(coffeeOrder.price())
        .isZero();
  }

  @Test
  public void smallCoffeeIs100() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size("small");

    assertThat(coffeeOrder.price())
        .isEqualTo(100);
  }

  @Test
  public void mediumCoffeeIs150() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size("medium");

    assertThat(coffeeOrder.price())
        .isEqualTo(150);
  }

  @Test
  public void largeCoffeeIs200() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size("large");

    assertThat(coffeeOrder.price())
        .isEqualTo(200);
  }

  @Test
  public void coffeeSmallChangedToLargeIs200() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size("small");
    coffeeOrder.size("large");

    assertThat(coffeeOrder.price())
        .isEqualTo(200);
  }

  @Test
  public void onlyMilkIs25() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.creamer("milk");

    assertThat(coffeeOrder.price())
        .isEqualTo(25);
  }

  @Test
  public void onlyHalfnHalfIs35() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.creamer("half-n-half");

    assertThat(coffeeOrder.price())
        .isEqualTo(35);
  }

  @Test
  public void mediumCoffeeWithHalfNHalfIs185() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size("medium");
    coffeeOrder.creamer("half-n-half");

    assertThat(coffeeOrder.price())
        .isEqualTo(185);
  }

}