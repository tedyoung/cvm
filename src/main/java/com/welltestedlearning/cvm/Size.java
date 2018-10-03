package com.welltestedlearning.cvm;

public class Size implements CoffeeItem {
  private final String size;

  public Size() {
    size = "";
  }

  public Size(String theSize) {
    size = theSize;
  }

  @Override
  public int price() {
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

  @Override
  public String display() {
    return "Size: " + size;
  }

}
