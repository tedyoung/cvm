package com.welltestedlearning.cvm.port;

import com.welltestedlearning.cvm.domain.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Primary
@Service
public class HttpCurrencyConversionService implements CurrencyConversionService {

  @Value("${currencyconversion.uri}")
  private String CONVERSION_URL;

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
