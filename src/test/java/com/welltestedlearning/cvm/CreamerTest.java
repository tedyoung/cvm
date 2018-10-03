package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreamerTest {

  @Test
  public void onlyMilkIs25() throws Exception {
    Creamer milk = new Creamer("milk");

    assertThat(milk.price())
        .isEqualTo(25);
  }

  @Test
  public void onlyHalfnHalfIs35() throws Exception {
    Creamer halfnhalf = new Creamer("half-n-half");

    assertThat(halfnhalf.price())
        .isEqualTo(35);
  }

}