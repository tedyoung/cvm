package com.welltestedlearning.cvm;

public class Creamer implements CoffeeItem {

  private static final int DEFAULT_QUANTITY = 1;

  private final int quantity;
  private String creamer = "";

  public Creamer(String type) {
    creamer = type;
    quantity = DEFAULT_QUANTITY;
  }

  public Creamer() {
    quantity = DEFAULT_QUANTITY;
  }

  public Creamer(String type, int theQuantity) {
    creamer = type;
    quantity = theQuantity;
  }

  public int price() {
    int price = 0;
    switch (creamer) {
      case "milk":
        price += 25;
        break;
      case "half-n-half":
        price += 35;
        break;
    }
    return price * quantity;
  }

  public String display() {
    return "Creamer: " + creamer;
  }
}
