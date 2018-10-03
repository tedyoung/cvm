package com.welltestedlearning.cvm;

public class Sweetener extends CoffeeItem {
  private final String type;

  public Sweetener() {
    type = "";
  }

  public Sweetener(String theType) {
    type = theType;
  }

  @Override
  public int price() {
    if (type.equals("sugar")) {
      return 10;
    } else if (type.equals("splenda")) {
      return 15;
    }
    return 0;
  }

  @Override
  public String display() {
    return "Sweetener: " + type;
  }

}
