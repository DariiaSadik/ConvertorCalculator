package com.sourceit.models;

/**
 * Created by Администратор on 22.12.2014.
 */
public class Currency {
    private double value;
    private String type;

    public Currency(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return value + type;

    }
}
