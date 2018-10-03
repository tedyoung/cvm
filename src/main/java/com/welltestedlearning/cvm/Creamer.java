package com.welltestedlearning.cvm;

public class Creamer extends QuantityItem implements CoffeeItem {

  private String creamer = "";

  public Creamer(String type) {
    creamer = type;
  }

  public Creamer() {
  }

  public Creamer(String type, int theQuantity) {
    super(theQuantity);
    creamer = type;
  }

  @Override
  public int basePrice() {
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

  public String display() {
    return "Creamer: " + creamer;
  }
}
