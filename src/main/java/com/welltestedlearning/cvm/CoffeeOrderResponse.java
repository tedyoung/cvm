package com.welltestedlearning.cvm;

public class CoffeeOrderResponse {
  private String id;
  private String price;
  private String poundPrice;
  private String name;

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
