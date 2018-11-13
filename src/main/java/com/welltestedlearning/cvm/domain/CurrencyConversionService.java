package com.welltestedlearning.cvm.domain;

import java.math.BigDecimal;

public interface CurrencyConversionService {
  int convertToBritishPound(int amount);

  BigDecimal convertToBitcoin(int amount);
}
