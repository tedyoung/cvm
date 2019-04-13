package com.welltestedlearning.cvm.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {

  CoffeeOrder findOne(Long id);

  CoffeeOrder save(CoffeeOrder coffeeOrder);

  @Query("select ...")
  List<CoffeeOrder> findByName(String name);

  List<CoffeeOrder> findAll();
}
