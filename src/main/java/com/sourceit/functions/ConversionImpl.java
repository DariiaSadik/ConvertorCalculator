package com.sourceit.functions;

import com.sourceit.exceptions.ConversionException;
import com.sourceit.models.Currency;

import java.util.Map;

public class ConversionImpl implements Conversion {
    @Override
    public Currency converting(Currency cur1, String function) throws ConversionException {
        ParseMap parseMap = new ParseMap();
        Map<String, Double> mapToOperation = parseMap.getRates(new PropertiesCurrency());
        if(function.equals(parseMap.getFunction())){
            String key = cur1.getType();
            if (mapToOperation.containsKey(key)){
               return new Currency(parseMap.getFormat().replace('X', ' ').trim(),
                       cur1.getValue()/mapToOperation.get(key));
            } else {
                throw new ConversionException("Error");
            }
        } else throw new ConversionException("Error");
    }

    public static void main(String[] args) throws ConversionException {
        System.out.println(new ConversionImpl().converting(new Currency("euro", 10), "toDollar"));
    }
}
