package com.welltestedlearning.cvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CoffeeOrderWebController {

  private CoffeeOrderRepository coffeeOrderRepository;

  @Autowired
  public CoffeeOrderWebController(CoffeeOrderRepository coffeeOrderRepository) {
    this.coffeeOrderRepository = coffeeOrderRepository;
  }

  @GetMapping("/coffee-order/{id}")
  public String coffeeOrderView(@PathVariable("id") String coffeeOrderId, Model model) {
    Long id = Long.valueOf(coffeeOrderId);
    CoffeeOrder coffeeOrder = coffeeOrderRepository.findOne(id);

    CoffeeOrderResponse response = new CoffeeOrderResponse();
    response.setId(String.valueOf(coffeeOrder.getId()));
    response.setPrice(String.valueOf(coffeeOrder.price()));
    response.setName(coffeeOrder.name());

    model.addAttribute("coffeeOrder", response);
    return "coffee-order-view";
  }

}
