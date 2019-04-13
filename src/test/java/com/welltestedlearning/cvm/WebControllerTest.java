package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.adapter.web.CoffeeOrderForm;
import com.welltestedlearning.cvm.adapter.web.CoffeeOrderWebController;
import com.welltestedlearning.cvm.domain.StubSendCoffeeOrderService;
import com.welltestedlearning.cvm.port.repository.FakeCoffeeOrderRepository;
import org.junit.Test;
import org.springframework.validation.MapBindingResult;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class WebControllerTest {
  @Test
  public void postWorks() throws Exception {
    FakeCoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrderWebController coffeeOrderWebController = new CoffeeOrderWebController(
        coffeeOrderRepository,
        new StubCurrencyConversionService(),
        new StubSendCoffeeOrderService());
    CoffeeOrderForm form = new CoffeeOrderForm();
    form.setName("Ted");
    form.setSize("LARGE");
    form.setCreamer("MILK");
    form.setSweetener("NONE");
    coffeeOrderWebController.processOrderCoffee(form, new MapBindingResult(Collections.emptyMap(), "coffeeOrderForm"));

    assertThat(coffeeOrderRepository.findAll())
        .hasSize(1);
  }
}