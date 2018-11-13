package com.welltestedlearning.cvm;


import com.welltestedlearning.cvm.domain.CoffeeOrder;
import com.welltestedlearning.cvm.domain.CoffeeOrderRepository;
import com.welltestedlearning.cvm.domain.CreamerOption;
import com.welltestedlearning.cvm.domain.SizeOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CoffeeOrderDataLoader implements ApplicationRunner {
  private CoffeeOrderRepository coffeeOrderRepository;

  @Autowired
  public CoffeeOrderDataLoader(CoffeeOrderRepository coffeeOrderRepository) {
    this.coffeeOrderRepository = coffeeOrderRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // create a couple of coffee orders and save them to the repository
    CoffeeOrder coffeeOrder1 = new CoffeeOrder();
    coffeeOrder1.size(SizeOption.MEDIUM);
    coffeeOrder1.changeNameTo("Megan");
    coffeeOrderRepository.save(coffeeOrder1);

    CoffeeOrder coffeeOrder2 = new CoffeeOrder();
    coffeeOrder2.size(SizeOption.LARGE);
    coffeeOrder2.creamer(CreamerOption.MILK);
    coffeeOrder2.changeNameTo("Bruce");
    coffeeOrderRepository.save(coffeeOrder2);
  }
}