package com.welltestedlearning.cvm;

import java.math.BigDecimal;

public class ConvertedCurrency {
  private String currency;
  private BigDecimal converted;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getConverted() {
    return converted;
  }

  public void setConverted(BigDecimal converted) {
    this.converted = converted;
  }
}
