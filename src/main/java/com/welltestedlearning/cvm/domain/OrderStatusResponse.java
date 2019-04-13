package com.welltestedlearning.cvm.domain;

public class OrderStatusResponse {
  private long orderNumber;
  private long kioskId;
  private String status;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
