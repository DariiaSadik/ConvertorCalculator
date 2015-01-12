package com.sourceit.models;

public class Currency {
    private double value;
    private String type;
    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

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

    @Override
    public String toString() {
        return format.replace("X", String.format("%.2f", value));
//        return String.format("%.2f%s", value, type);
    }
}
