package com.welltestedlearning.cvm.domain;

public class Quantity {
  private int quantity = 1;

  public int multiply(int amount) {
    return amount * quantity;
  }
}
