package com.welltestedlearning.cvm;

public class Sweetener extends QuantityItem implements CoffeeItem {
  private final SweetenerOption sweetenerOption;

  public Sweetener(SweetenerOption theSweetenerOption) {
    sweetenerOption = theSweetenerOption;
  }

  public Sweetener(SweetenerOption theSweetenerOption, int theQuantity) {
    super(theQuantity);
    sweetenerOption = theSweetenerOption;
  }

  @Override
  public int basePrice() {
    final int price;
    switch (sweetenerOption) {
      case SUGAR:
        price = 10;
        break;
      case SPLENDA:
        price = 15;
        break;
      default:
        price = 0;
    }
    return price;
  }

  @Override
  public String display() {
    return "Sweetener: " + sweetenerOption;
  }

}
