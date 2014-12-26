package com.sourceit.functions;

import java.util.*;

/**
 * Created by Администратор on 26.12.2014.
 */
public class ParseMap {
    private String function;
    private String format;
    private Map<String, Double> rates;

    public LinkedList<String> toSimple(PropertiesCurrency propertiesCurrency){
        LinkedList<String> keys = new LinkedList<>();
        for (LinkedList key : propertiesCurrency.parseString().keySet()) {
            keys = key;
        }
        return keys;
    }
    public String getFunction() {
        LinkedList<String> functionList = toSimple(new PropertiesCurrency());
        function = functionList.get(0);
        return function;
    }

    public String getFormat() {
        LinkedList<String> functionList = toSimple(new PropertiesCurrency());
        format = functionList.get(1);
        return format;
    }

    public Map<String, Double> getRates(PropertiesCurrency propertiesCurrency) {
        for (LinkedList key : propertiesCurrency.parseString().keySet()) {
            rates = propertiesCurrency.parseString().get(key);
        }
        return rates;
    }

    public static void main(String[] args) {
        System.out.println(new ParseMap().getFunction().toString());
        System.out.println(new ParseMap().getFormat().toString());
        System.out.println(new ParseMap().getRates(new PropertiesCurrency()).toString());
    }
}
