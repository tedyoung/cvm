package com.welltestedlearning.cvm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderApiController {

  private CoffeeOrderRepository coffeeOrderRepository;

  @Autowired
  public CoffeeOrderApiController(CoffeeOrderRepository coffeeOrderRepository) {
    this.coffeeOrderRepository = coffeeOrderRepository;
  }

  @GetMapping("/api/coffeeorders/{id}")
  public ResponseEntity<CoffeeOrderResponse> coffeeOrderInfo(@PathVariable("id") String coffeeOrderId) {
    Long id = Long.valueOf(coffeeOrderId);
    CoffeeOrder coffeeOrder = coffeeOrderRepository.findOne(id);
    if (coffeeOrder == null) {
      return ResponseEntity.notFound().build();
    }

    CoffeeOrderResponse response = new CoffeeOrderResponse();
    response.setId(String.valueOf(coffeeOrder.getId()));
    int price = coffeeOrder.price();
    response.setPrice(String.valueOf(price));

    return ResponseEntity.ok(response);
  }

}
