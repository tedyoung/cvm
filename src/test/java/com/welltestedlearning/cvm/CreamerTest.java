package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreamerTest {

  @Test
  public void onlyMilkIs25() throws Exception {
    Creamer milk = new Creamer(CreamerOption.MILK);

    assertThat(milk.price())
        .isEqualTo(25);
  }

  @Test
  public void onlyHalfnHalfIs35() throws Exception {
    Creamer halfnhalf = new Creamer(CreamerOption.HALF_N_HALF);

    assertThat(halfnhalf.price())
        .isEqualTo(35);
  }

  @Test
  public void twoMilksCost50() throws Exception {
    Creamer milks = new Creamer(CreamerOption.MILK, 2);

    assertThat(milks.price())
        .isEqualTo(50);
  }

}