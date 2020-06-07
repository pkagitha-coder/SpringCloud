package org.abc.microservices.currencyconversionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConverterController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionValue convertCurrency(@PathVariable String from,
                                                   @PathVariable String to,
                                                   @PathVariable BigDecimal quantity) {
        return new CurrencyConversionValue(from,to, BigDecimal.valueOf(65),quantity);
    }
}
