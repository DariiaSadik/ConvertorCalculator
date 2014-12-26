package com.sourceit.functions;

import com.sourceit.models.Currency;
import com.sourceit.exceptions.ConversionException;
public interface Conversion {
    public Currency converting (Currency cur1, String function) throws ConversionException;
}
