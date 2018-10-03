package com.welltestedlearning.cvm;

public class Sweetener implements CoffeeItem {
  private final String type;
  private final int quantity;

  public Sweetener(String theType) {
    type = theType;
    quantity = 1;
  }

  public Sweetener(String option, int theQuantity) {
    type = option;
    quantity = theQuantity;
  }

  @Override
  public int price() {
    final int price;
    switch (type) {
      case "sugar":
        price = 10;
        break;
      case "splenda":
        price = 15;
        break;
      default:
        price = 0;
        break;
    }
    return price * quantity;
  }

  @Override
  public String display() {
    return "Sweetener: " + type;
  }

}
