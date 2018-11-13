package com.welltestedlearning.cvm.adapter.api;


import com.welltestedlearning.cvm.adapter.CoffeeOrderResponse;
import com.welltestedlearning.cvm.domain.CoffeeOrder;
import com.welltestedlearning.cvm.domain.CoffeeOrderRepository;
import com.welltestedlearning.cvm.domain.CreamerOption;
import com.welltestedlearning.cvm.domain.CurrencyConversionService;
import com.welltestedlearning.cvm.domain.SizeOption;
import com.welltestedlearning.cvm.domain.SweetenerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderApiController {

  private CoffeeOrderRepository coffeeOrderRepository;
  private CurrencyConversionService currencyConversionService;

  @Autowired
  public CoffeeOrderApiController(CoffeeOrderRepository coffeeOrderRepository, CurrencyConversionService currencyConversionService) {
    this.coffeeOrderRepository = coffeeOrderRepository;
    this.currencyConversionService = currencyConversionService;
  }

  @GetMapping("/api/coffeeorders/{id}")
  public ResponseEntity<CoffeeOrderResponse> coffeeOrderInfo(@PathVariable("id") String coffeeOrderId,
      @RequestParam(value = "currency", defaultValue = "usd") String currency) {
    Long id = Long.valueOf(coffeeOrderId);
    CoffeeOrder coffeeOrder = coffeeOrderRepository.findOne(id);
    if (coffeeOrder == null) {
      return ResponseEntity.notFound().build();
    }

    CoffeeOrderResponse response = new CoffeeOrderResponse();
    response.setId(String.valueOf(coffeeOrder.getId()));

    int price = coffeeOrder.price();
    if (currency.equalsIgnoreCase("gbp")) {
      price = currencyConversionService.convertToBritishPound(price);
    }

    response.setPrice(String.valueOf(price));
    response.setName(coffeeOrder.name());

    return ResponseEntity.ok(response);
  }

  @PostMapping("/api/coffeeorders")
  public CoffeeOrderResponse createCoffeeOrder(@RequestBody CoffeeOrderCreateRequest request) {
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.changeNameTo(request.getName());
    coffeeOrder.size(SizeOption.valueOf(request.getSize()));
    coffeeOrder.creamer(CreamerOption.valueOf(request.getCreamer()));
    coffeeOrder.sweetener(SweetenerOption.valueOf(request.getSweetener()));

    CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);

    CoffeeOrderResponse response = new CoffeeOrderResponse();
    response.setId(String.valueOf(savedCoffeeOrder.getId()));
    int price = savedCoffeeOrder.price();
    response.setPrice(String.valueOf(price));
    response.setName(savedCoffeeOrder.name());

    return response;
  }

}
