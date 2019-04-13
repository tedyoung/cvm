package com.welltestedlearning.cvm.adapter.web;

import com.welltestedlearning.cvm.adapter.CoffeeOrderResponse;
import com.welltestedlearning.cvm.domain.CoffeeItem;
import com.welltestedlearning.cvm.domain.CoffeeOrder;
import com.welltestedlearning.cvm.domain.CoffeeOrderRepository;
import com.welltestedlearning.cvm.domain.CreamerOption;
import com.welltestedlearning.cvm.domain.CurrencyConversionService;
import com.welltestedlearning.cvm.domain.SendCoffeeOrderService;
import com.welltestedlearning.cvm.domain.SizeOption;
import com.welltestedlearning.cvm.domain.SweetenerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CoffeeOrderWebController {

  private CoffeeOrderRepository coffeeOrderRepository;
  private CurrencyConversionService currencyConversionService;
  private SendCoffeeOrderService sendCoffeeOrderService;

  @Autowired
  public CoffeeOrderWebController(CoffeeOrderRepository coffeeOrderRepository,
      CurrencyConversionService currencyConversionService,
      SendCoffeeOrderService sendCoffeeOrderService) {
    this.coffeeOrderRepository = coffeeOrderRepository;
    this.currencyConversionService = currencyConversionService;
    this.sendCoffeeOrderService = sendCoffeeOrderService;
  }

  @GetMapping("/coffee-order/{id}")
  public String coffeeOrderView(@PathVariable("id") String coffeeOrderId, Model model) {
    CoffeeOrder coffeeOrder = lookupCoffeeOrder(coffeeOrderId);

    CoffeeOrderResponse response = CoffeeOrderResponse.convertFrom(coffeeOrder);

    enrichWithGbpPrice(coffeeOrder, response);
    enrichWithOrderStatus(coffeeOrder, response);

    model.addAttribute("coffeeOrder", response);

    List<String> coffeeItems = convertFrom(coffeeOrder.items());
    model.addAttribute("coffeeItems", coffeeItems);

    model.addAttribute("id", coffeeOrder.getId());
    return "coffee-order-view";
  }

  private void enrichWithOrderStatus(CoffeeOrder coffeeOrder, CoffeeOrderResponse response) {
    Long orderNumber = coffeeOrder.orderNumber();
    if (orderNumber == null) {
      response.setStatus("Not Sent");
    } else {
      response.setStatus(sendCoffeeOrderService.statusFor(orderNumber));
    }
  }

  private CoffeeOrder lookupCoffeeOrder(@PathVariable("id") String coffeeOrderId) {
    Long id = Long.valueOf(coffeeOrderId);
    CoffeeOrder coffeeOrder = coffeeOrderRepository.findOne(id);
    if (coffeeOrder == null) {
      throw new CoffeeOrderNotFoundHttpException();
    }
    return coffeeOrder;
  }

  private List<String> convertFrom(List<CoffeeItem> items) {
    return items.stream()
                .map(CoffeeItem::display)
                .collect(Collectors.toList());
  }

  private void enrichWithGbpPrice(CoffeeOrder coffeeOrder, CoffeeOrderResponse response) {
    int poundPrice = currencyConversionService.convertToBritishPound(coffeeOrder.price());
    response.setPoundPrice(String.valueOf(poundPrice));
  }

  @PostMapping("/send-order")
  public String sendOrder(@ModelAttribute("id") String id) {
    CoffeeOrder coffeeOrder = lookupCoffeeOrder(id);
    long orderNumber = sendCoffeeOrderService.send(coffeeOrder);
    coffeeOrder.updateOrderNumberTo(orderNumber);
    coffeeOrderRepository.save(coffeeOrder);
    return "redirect:/coffee-order/" + id;
  }

  @GetMapping("/order-coffee")
  public String orderCoffeeForm(Model model) {
    CoffeeOrderForm coffeeOrderForm = new CoffeeOrderForm();
    coffeeOrderForm.setSize("LARGE");
    coffeeOrderForm.setCreamer("NONE");
    model.addAttribute("coffeeOrderForm", coffeeOrderForm);
    return "order-coffee-form";
  }

  @PostMapping("/order-coffee")
  public String processOrderCoffee(@Valid CoffeeOrderForm coffeeOrderForm, BindingResult bindingResult) {
    SizeOption sizeOption = null;
    try {
      sizeOption = SizeOption.valueOf(coffeeOrderForm.getSize().toUpperCase());
    } catch (IllegalArgumentException e) {
      bindingResult.rejectValue("size", null, "Invalid size option");
    }

    if (bindingResult.hasErrors()) {
      return "order-coffee-form";
    }


    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.changeNameTo(coffeeOrderForm.getName());
    coffeeOrder.size(sizeOption);
    coffeeOrder.creamer(CreamerOption.valueOf(coffeeOrderForm.getCreamer().toUpperCase()));
    coffeeOrder.sweetener(SweetenerOption.valueOf(coffeeOrderForm.getSweetener().toUpperCase()));
    CoffeeOrder savedOrder = coffeeOrderRepository.save(coffeeOrder);

    return "redirect:/coffee-order/" + savedOrder.getId();
  }

  @GetMapping("/coffee-orders")
  public String allOrders(Model model) {
    List<CoffeeOrder> coffeeOrders = coffeeOrderRepository.findAll();

    List<CoffeeOrderResponse> responses = coffeeOrders.stream()
                                                      .map(CoffeeOrderResponse::convertFrom)
                                                      .collect(Collectors.toList());

    model.addAttribute("coffeeOrders", responses);
    return "all-coffee-orders";
  }

}
