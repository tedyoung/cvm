package com.welltestedlearning.cvm.domain;

public class Creamer extends QuantityItem implements CoffeeItem {

  private CreamerOption creamerOption;

  public Creamer(CreamerOption creamerOption) {
    this.creamerOption = creamerOption;
  }

  public Creamer() {
  }

  public Creamer(CreamerOption type, int theQuantity) {
    super(theQuantity);
    creamerOption = type;
  }

  @Override
  public int basePrice() {
    int price = 0;
    switch (creamerOption) {
      case MILK:
        price = 25;
        break;
      case HALF_N_HALF:
        price = 35;
        break;
      case NONE:
        break;
    }
    return price;
  }

  public String display() {
    return "Creamer: " + creamerOption;
  }
}
