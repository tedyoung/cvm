package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.domain.CoffeeOrder;
import com.welltestedlearning.cvm.domain.CoffeeOrderRepository;
import com.welltestedlearning.cvm.domain.CreamerOption;
import com.welltestedlearning.cvm.domain.SizeOption;
import com.welltestedlearning.cvm.port.repository.FakeCoffeeOrderRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderRepositorySaveTest {

  @Test
  public void updateOrderViaSaveCanBeFound() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();

    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.setId(3L);
    coffeeOrder.size(SizeOption.LARGE);

    coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrder foundOrder = coffeeOrderRepository.findOne(3L);
    assertThat(foundOrder)
        .isNotNull();
    assertThat(foundOrder.price())
        .isEqualTo(200);
  }

  @Test
  public void saveModifiedCoffeeOrderIsReturned() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();

    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.setId(3L);
    coffeeOrder.size(SizeOption.LARGE);

    coffeeOrderRepository.save(coffeeOrder);

    coffeeOrder.creamer(CreamerOption.MILK);
    coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrder found = coffeeOrderRepository.findOne(3L);

    assertThat(found.price())
        .isEqualTo(225);
  }

  @Test
  public void saveNewOrderHasIdAssigned() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();

    CoffeeOrder coffeeOrder = new CoffeeOrder();
    CoffeeOrder savedOrder = coffeeOrderRepository.save(coffeeOrder);

    assertThat(savedOrder.getId())
        .isNotNull();
  }

  @Test
  public void newlySavedCoffeeOrdersHaveUniqueIds() {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();
    CoffeeOrder coffeeOrder1 = new CoffeeOrder();
    coffeeOrder1 = coffeeOrderRepository.save(coffeeOrder1);
    CoffeeOrder coffeeOrder2 = new CoffeeOrder();
    coffeeOrder2 = coffeeOrderRepository.save(coffeeOrder2);

    assertThat(coffeeOrder1.getId())
        .isNotEqualTo(coffeeOrder2.getId());
  }

}
