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
  public void mediumCoffeeWithHalfNHalfIs185() throws Exception {
    CoffeeOrder coffeeOrder = new CoffeeOrder();

    coffeeOrder.size(SizeOption.MEDIUM);
    coffeeOrder.creamer(CreamerOption.HALF_N_HALF);

    assertThat(coffeeOrder.price())
        .isEqualTo(185);
  }

}