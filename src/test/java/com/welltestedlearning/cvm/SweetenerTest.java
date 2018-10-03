package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SweetenerTest {

  @Test
  public void sugarTypeIs10() throws Exception {
    Sweetener sugar = new Sweetener("sugar");

    assertThat(sugar.price())
        .isEqualTo(10);
  }

  @Test
  public void splendaTypeIs15() throws Exception {
    Sweetener splenda = new Sweetener("splenda");

    assertThat(splenda.price())
        .isEqualTo(15);
  }

}