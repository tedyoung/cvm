package com.welltestedlearning.cvm;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Primary
@Service
public class HttpCurrencyConversionService implements CurrencyConversionService {

  private static final String CONVERSION_URL =
      "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public int convertToBritishPound(int amount) {
    return convertToCurrency(amount, "GBP").intValue();
  }

  @Override
  public BigDecimal convertToBitcoin(int amount) {
    return convertToCurrency(amount, "BTC");
  }

  private BigDecimal convertToCurrency(int amount, String targetCurrency) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("to", targetCurrency);
    uriVariables.put("from", "USD");
    uriVariables.put("amount", String.valueOf(amount));

    ConvertedCurrency convertedCurrency = restTemplate.getForObject(
        CONVERSION_URL, ConvertedCurrency.class, uriVariables);

    return convertedCurrency.getConverted();
  }
}
