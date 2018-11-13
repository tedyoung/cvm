package com.welltestedlearning.cvm.domain;

public abstract class QuantityItem {
  private int quantity;

  protected QuantityItem() {
    quantity = 1;
  }

  public QuantityItem(int quantity) {
    this.quantity = quantity;
  }

  public int price() {
    return basePrice() * quantity;
  }

  public abstract int basePrice();
}