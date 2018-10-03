package com.welltestedlearning.cvm;

public class Creamer extends CoffeeItem {

  private String creamer = "";

  public Creamer(String type) {
    creamer = type;
  }

  public Creamer() {
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
    return price;
  }

  @Override
  public String display() {
    return "Creamer: " + creamer;
  }
}
