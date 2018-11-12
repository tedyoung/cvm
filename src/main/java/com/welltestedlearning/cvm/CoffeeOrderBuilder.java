package com.welltestedlearning.cvm;

public class CoffeeOrderBuilder {
  private String size;
  private String creamer = "n";
  private String sweetener = "n";

  public CoffeeOrderBuilder size(String letter) {
    size = letter;
    return this;
  }

  public CoffeeOrderBuilder creamer(String letter) {
    creamer = letter;
    return this;
  }

  public CoffeeOrderBuilder sweetener(String letter) {
    sweetener = letter;
    return this;
  }

  public CoffeeOrder build() {
    CoffeeOrder coffeeOrder = new CoffeeOrder();
    coffeeOrder.size(SizeOption.fromLetter(size));
    coffeeOrder.creamer(CreamerOption.fromLetter(creamer));
    coffeeOrder.sweetener(SweetenerOption.fromLetter(sweetener));
    return coffeeOrder;
  }
}