package com.welltestedlearning.cvm;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {
  private List<CoffeeItem> coffeeItems = new ArrayList<>();

  public int price() {
    int price = 0;
    for (CoffeeItem item : coffeeItems) {
      price += item.price();
    }
    return price;
  }

  public void display() {
    for (CoffeeItem item : coffeeItems) {
      System.out.println(item.display());
    }
    System.out.println("Price: " + price());
  }

  public void size(String size) {
    coffeeItems.add(new Size(size));
  }

  public void creamer(String creamer) {
    coffeeItems.add(new Creamer(creamer));
  }

  public void sweetener(String sweetener) {
    coffeeItems.add(new Sweetener(sweetener));
  }
}
