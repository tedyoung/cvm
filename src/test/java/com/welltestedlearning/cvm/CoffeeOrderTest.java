package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.domain.CoffeeOrder;
import com.welltestedlearning.cvm.domain.CreamerOption;
import com.welltestedlearning.cvm.domain.SizeOption;
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