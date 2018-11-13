package com.welltestedlearning.cvm.domain;

import java.util.List;

public interface CoffeeOrderRepository {

  CoffeeOrder findOne(Long id);

  CoffeeOrder save(CoffeeOrder coffeeOrder);

  List<CoffeeOrder> findAll();
}
