package com.welltestedlearning.cvm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderRepositoryFindTest {

  @Test
  public void findAllForNewRepositoryReturnsEmptyList() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();

    assertThat(coffeeOrderRepository.findAll())
        .isEmpty();
  }

  @Test
  public void findAllShouldReturn2Orders() {
    CoffeeOrder coffeeOrder1 = new CoffeeOrder();
    coffeeOrder1.setId(1L);
    CoffeeOrder coffeeOrder2 = new CoffeeOrder();
    coffeeOrder2.setId(2L);

    CoffeeOrderRepository repo = new FakeCoffeeOrderRepository(coffeeOrder1, coffeeOrder2);
    assertThat(repo.findAll())
        .hasSize(2);
  }

  @Test
  public void findOneNonExistentOrderReturnsNull() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new FakeCoffeeOrderRepository();

    assertThat(coffeeOrderRepository.findOne(1L))
        .isNull();
  }

  @Test
  public void findOneExistingOrderReturnsThatOrder() throws Exception {
    CoffeeOrder coffeeOrder1 = new CoffeeOrder();
    coffeeOrder1.setId(1L);

    CoffeeOrderRepository repo = new FakeCoffeeOrderRepository(coffeeOrder1);

    assertThat(repo.findOne(1L))
        .isNotNull();

    assertThat(repo.findOne(1L).getId())
        .isEqualTo(1L);
  }
}
