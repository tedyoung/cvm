package com.welltestedlearning.cvm.domain;

public class Size implements CoffeeItem {
  private final SizeOption sizeOption;

  public Size() {
    sizeOption = SizeOption.SMALL;
  }

  public Size(SizeOption theSizeOption) {
    sizeOption = theSizeOption;
  }

  @Override
  public int price() {
    int price = 0;
    switch (sizeOption) {
      case SMALL:
        price = 100;
        break;
      case MEDIUM:
        price = 150;
        break;
      case LARGE:
        price = 200;
        break;
    }
    return price;
  }

  @Override
  public String display() {
    return "Size: " + sizeOption;
  }

}
