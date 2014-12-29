package com.sourceit.functions;

import com.sourceit.exceptions.ConversionException;
import com.sourceit.models.Currency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConversionImpl implements Conversion {
    @Override
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
//                        System.out.println(getFormat + " " + getFunction + " "
//                                + cur1 + " " + rates.get(cur1.getType()));
                        currency = new Currency(getFormat, cur1.getValue() / rates.get(cur1.getType()));
                    } else throw new ConversionException("Cannot conversion!");
                }
            }
        return currency;
    }

    public static void main(String[] args) throws ConversionException {
        System.out.println(new ConversionImpl().converting(new Currency("UAN", 10), "toEuro"));
        System.out.println(new Currency("UAN", 10).getType());
        System.out.println(new ConversionImpl().converting(new Currency("$", 10), "toEuro"));
        System.out.println(new ConversionImpl().converting(new Currency("UAN", 10), "toDollar"));
        System.out.println(new ConversionImpl().converting(new Currency("euro", 10), "toDollar"));
    }
}
