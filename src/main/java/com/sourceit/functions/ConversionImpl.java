package com.sourceit.functions;

import com.sourceit.exceptions.ConversionException;
import com.sourceit.models.Currency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConversionImpl {
    public Currency converting(Currency cur1, String function) throws ConversionException {
        Currency currency = null;
        for (LinkedList<String> key : new PropertiesCurrency().parseString().keySet()) {
            LinkedList<String> keys = new LinkedList<>();
            keys.addAll(key);
            String getFunction = keys.get(0);
            String getFormat = keys.get(1);
            if(function.equals(getFunction)) {
                Map<String, Double> rates = new HashMap<>();
                rates.putAll(new PropertiesCurrency().parseString().get(key));
                    if (rates.containsKey(cur1.getType())) {
                        if(rates.get(cur1.getType()) != 0) {
                            currency = new Currency(getFormat.replace("X", ""),
                                    cur1.getValue() / rates.get(cur1.getType()));
                            currency.setFormat(getFormat);
                        } else throw new ConversionException("rate is 0");
                    } else throw new ConversionException("Cannot conversion!");
                }
            }
        return currency;
    }
}
