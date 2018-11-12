package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeTest {

  @Test
  public void smallCoffeeIs100() throws Exception {
    Size small = new Size(SizeOption.SMALL);

    assertThat(small.price())
        .isEqualTo(100);
  }

  @Test
  public void mediumCoffeeIs150() throws Exception {
    Size medium = new Size(SizeOption.MEDIUM);

    assertThat(medium.price())
        .isEqualTo(150);
  }

  @Test
  public void largeCoffeeIs200() throws Exception {
    Size large = new Size(SizeOption.LARGE);

    assertThat(large.price())
        .isEqualTo(200);
  }

}