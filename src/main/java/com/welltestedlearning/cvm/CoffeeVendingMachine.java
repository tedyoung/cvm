package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.adapter.CoffeeOrderBuilder;
import com.welltestedlearning.cvm.domain.CoffeeOrder;

import java.util.Scanner;

public class CoffeeVendingMachine {

  public static void main(String[] args) {

    CoffeeOrderBuilder coffeeOrderBuilder = new CoffeeOrderBuilder();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Coffee Size? (S)mall, (M)edium, (L)arge");
    String sizeRequested = scanner.nextLine();

    System.out.println("Creamer? (N)one, (M)ilk, (H)alf-n-half");
    String creamerRequested = scanner.nextLine();

    System.out.println("Sweetener? (N)one, (S)ugar, s(P)lenda");
    String sweetenerRequested = scanner.nextLine();

    CoffeeOrder coffeeOrder = coffeeOrderBuilder.size(sizeRequested)
                                                .creamer(creamerRequested)
                                                .sweetener(sweetenerRequested)
                                                .build();
    coffeeOrder.display();
  }

}
