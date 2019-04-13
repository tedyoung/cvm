package com.welltestedlearning.cvm.domain;

public class SentOrderResponse {
  private long orderNumber;
  private long kioskId;

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public long getKioskId() {
    return kioskId;
  }

  public void setKioskId(long kioskId) {
    this.kioskId = kioskId;
  }
}
