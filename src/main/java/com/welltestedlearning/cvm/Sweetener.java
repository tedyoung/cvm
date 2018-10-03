package com.welltestedlearning.cvm;

public class Sweetener extends QuantityItem implements CoffeeItem {
  private final String type;

  public Sweetener(String theType) {
    type = theType;
  }

  public Sweetener(String option, int theQuantity) {
    super(theQuantity);
    type = option;
  }

  @Override
  public int basePrice() {
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
    return price;
  }

  @Override
  public String display() {
    return "Sweetener: " + type;
  }

}
