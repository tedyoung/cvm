package com.welltestedlearning.cvm;

import org.springframework.stereotype.Service;

@Service
public class StubCurrencyConversionService implements CurrencyConversionService {
  @Override
  public int convertToBritishPound(int amount) {
    return 1234;
  }
}
