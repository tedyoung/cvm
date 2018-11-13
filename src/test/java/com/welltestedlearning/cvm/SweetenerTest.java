package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.domain.Sweetener;
import com.welltestedlearning.cvm.domain.SweetenerOption;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SweetenerTest {

  @Test
  public void sugarTypeIs10() throws Exception {
    Sweetener sugar = new Sweetener(SweetenerOption.SUGAR);

    assertThat(sugar.price())
        .isEqualTo(10);
  }

  @Test
  public void splendaTypeIs15() throws Exception {
    Sweetener splenda = new Sweetener(SweetenerOption.SPLENDA);

    assertThat(splenda.price())
        .isEqualTo(15);
  }

  @Test
  public void threeSplendaIs45() throws Exception {
    Sweetener splendas = new Sweetener(SweetenerOption.SPLENDA, 3);

    assertThat(splendas.price())
        .isEqualTo(45);
  }
}