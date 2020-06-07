package org.abc.microservices.currencyconversionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConverterController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionValue convertCurrency(@PathVariable String from,
                                                   @PathVariable String to,
                                                   @PathVariable BigDecimal quantity) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);

        ResponseEntity<CurrencyConversionValue> exchangeValueResp = new RestTemplate().
                getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionValue.class, urlVariables);
        CurrencyConversionValue body = exchangeValueResp.getBody();
        return new CurrencyConversionValue(from, to, body.getConversionMultiple(), quantity);
    }
}
