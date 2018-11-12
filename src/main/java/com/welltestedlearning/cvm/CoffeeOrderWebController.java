package com.welltestedlearning.cvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CoffeeOrderWebController {

  private CoffeeOrderRepository coffeeOrderRepository;
  private CurrencyConversionService currencyConversionService;

  @Autowired
  public CoffeeOrderWebController(CoffeeOrderRepository coffeeOrderRepository, CurrencyConversionService currencyConversionService) {
    this.coffeeOrderRepository = coffeeOrderRepository;
    this.currencyConversionService = currencyConversionService;
  }

  @GetMapping("/coffee-order/{id}")
  public String coffeeOrderView(@PathVariable("id") String coffeeOrderId, Model model) {
    Long id = Long.valueOf(coffeeOrderId);
    CoffeeOrder coffeeOrder = coffeeOrderRepository.findOne(id);
    if (coffeeOrder == null) {
      throw new CoffeeOrderNotFoundHttpException();
    }

    CoffeeOrderResponse response = CoffeeOrderResponse.convertFrom(coffeeOrder);

    int price = coffeeOrder.price();
    int poundPrice = currencyConversionService.convertToBritishPound(price);
    response.setPoundPrice(String.valueOf(poundPrice));

    model.addAttribute("coffeeOrder", response);
    return "coffee-order-view";
  }

  @GetMapping("/order-coffee")
  public String orderCoffeeForm() {
    return "order-coffee-form";
  }

  @PostMapping("/order-coffee")
  public String processOrderCoffee(@ModelAttribute("name") String name,
      @ModelAttribute("size") String size) {
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.changeNameTo(name);
    coffeeOrder.size(SizeOption.valueOf(size.toUpperCase()));
    CoffeeOrder savedOrder = coffeeOrderRepository.save(coffeeOrder);

    return "redirect:/coffee-order/" + savedOrder.getId();
  }

  @GetMapping("/coffee-orders")
  public String allOrders(Model model) {
    List<CoffeeOrder> coffeeOrders = coffeeOrderRepository.findAll();

    List<CoffeeOrderResponse> responses = coffeeOrders.stream()
                                                      .map(CoffeeOrderResponse::convertFrom)
                                                      .collect(Collectors.toList());

    //  The above stream + lambda is the same as this loop:
//    List<CoffeeOrderResponse> responses = new ArrayList<>();
//    for (CoffeeOrder coffeeOrder : coffeeOrders) {
//      CoffeeOrderResponse response = CoffeeOrderResponse.convertFrom(coffeeOrder);
//      responses.add(response);
//    }

    model.addAttribute("coffeeOrders", responses);
    return "all-coffee-orders";
  }

}
