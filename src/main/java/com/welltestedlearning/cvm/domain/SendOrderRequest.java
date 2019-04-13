package com.welltestedlearning.cvm.domain;

import java.util.List;

public class SendOrderRequest {
  private static final String KIOSK_NAME = "TED";
  private String kioskName;
  private long kioskId;
  private List<String> items;

  public static SendOrderRequest from(CoffeeOrder coffeeOrder) {
    SendOrderRequest sendOrderRequest = new SendOrderRequest();
    sendOrderRequest.setKioskId(coffeeOrder.getId());
    sendOrderRequest.setKioskName(KIOSK_NAME);
    //
    // convert the coffee order's `CoffeeItem`s to a `List<String>` here
    // List<String> coffeeItems = ...
    //
//    sendOrderRequest.setItems(coffeeItems);
    return sendOrderRequest;
  }


  public String getKioskName() {
    return kioskName;
  }

  public void setKioskName(String kioskName) {
    this.kioskName = kioskName;
  }

  public long getKioskId() {
    return kioskId;
  }

  public void setKioskId(long kioskId) {
    this.kioskId = kioskId;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }
}
