package com.welltestedlearning.cvm;

import com.welltestedlearning.cvm.domain.CurrencyConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StubCurrencyConversionService implements CurrencyConversionService {
  @Override
  public int convertToBritishPound(int amount) {
    return 1234;
  }

  @Override
  public BigDecimal convertToBitcoin(int amount) {
    return BigDecimal.TEN;
  }
}
