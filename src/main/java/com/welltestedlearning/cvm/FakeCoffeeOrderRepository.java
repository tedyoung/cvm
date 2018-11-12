package com.welltestedlearning.cvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FakeCoffeeOrderRepository implements CoffeeOrderRepository {

  private Map<Long, CoffeeOrder> coffeeOrderMap = new HashMap<>();
  private AtomicLong counter = new AtomicLong();

  @Autowired // ensure this constructor is used during auto-wiring process by Spring
  public FakeCoffeeOrderRepository() {
  }

  FakeCoffeeOrderRepository(CoffeeOrder... coffeeOrders) {
    for (CoffeeOrder coffeeOrder : coffeeOrders) {
      save(coffeeOrder);
    }
  }

  @Override
  public CoffeeOrder findOne(Long id) {
    return coffeeOrderMap.get(id);
  }

  @Override
  public CoffeeOrder save(CoffeeOrder coffeeOrder) {
    if (coffeeOrder.getId() == null) {
      coffeeOrder.setId(counter.getAndIncrement());
    }
    coffeeOrderMap.put(coffeeOrder.getId(), coffeeOrder);
    return coffeeOrder;
  }

  @Override
  public List<CoffeeOrder> findAll() {
    return new ArrayList<>(coffeeOrderMap.values());
  }
}
