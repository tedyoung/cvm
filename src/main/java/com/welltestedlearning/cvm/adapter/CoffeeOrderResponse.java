package com.welltestedlearning.cvm.adapter;

import com.welltestedlearning.cvm.domain.CoffeeOrder;

public class CoffeeOrderResponse {
  private String id;
  private String price;
  private String poundPrice;
  private String name;
  private String status;

  public static CoffeeOrderResponse convertFrom(CoffeeOrder coffeeOrder) {
    CoffeeOrderResponse response = new CoffeeOrderResponse();

    response.setId(String.valueOf(coffeeOrder.getId()));
    response.setPrice(String.valueOf(coffeeOrder.price()));
    response.setName(coffeeOrder.name());

    return response;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPoundPrice() {
    return poundPrice;
  }

  public void setPoundPrice(String poundPrice) {
    this.poundPrice = poundPrice;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
