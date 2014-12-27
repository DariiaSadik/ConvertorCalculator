package com.sourceit.models;

import com.sourceit.functions.ParseMap;

/**
 * Created by Администратор on 22.12.2014.
 */
public class Currency {
    private double value;
    private String type;
    private String format = new ParseMap().getFormat();

    public Currency(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return value + type;

    }
}
