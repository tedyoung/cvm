package com.welltestedlearning.cvm;

public class CoffeeVendingMachine {
  public static void main(String[] args) {
    CoffeeOrder order1 = new CoffeeOrder();
    order1.size("medium");
    order1.creamer("milk");
    order1.sweetener("sugar");
    order1.display();

    System.out.println("----");

    CoffeeOrder order2 = new CoffeeOrder();
    order2.size("large");
    order2.display();
  }
}
