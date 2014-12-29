package com.sourceit.models;

import com.sourceit.functions.PropertiesCurrency;
import java.util.LinkedList;

public class Currency {
    private double value;
    private String type;
    private String format;

    public Currency(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getFormat() {
        for (LinkedList<String> key : new PropertiesCurrency().parseString().keySet()) {
            LinkedList<String> keys = new LinkedList<>();
            keys.addAll(key);
            for (String key1 : keys) {
                if (key1.equals(type)) {
                    format = key1.replaceAll("X", (String.format("%.2f", value) + ""));

                }
            }
        }
        return format;
    }

    @Override
    public String toString() {
        return String.format("%.2f", value) + type;
    }
}
