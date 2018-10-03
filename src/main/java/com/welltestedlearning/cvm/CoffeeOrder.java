package com.welltestedlearning.cvm;

public class CoffeeOrder {
  private String size = "";
  private String creamer = "";

  public int price() {
    return sizePrice() + creamerPrice();
  }

  private int creamerPrice() {
    int price = 0;
    switch (creamer) {
      case "milk":
        price += 25;
        break;
      case "half-n-half":
        price += 35;
        break;
    }
    return price;
  }

  private int sizePrice() {
    int price = 0;
    switch (size) {
      case "small":
        price += 100;
        break;
      case "medium":
        price += 150;
        break;
      case "large":
        price += 200;
        break;
    }
    return price;
  }

  public void size(String size) {
    this.size = size;
  }

  public void creamer(String creamer) {
    this.creamer = creamer;
  }
}
