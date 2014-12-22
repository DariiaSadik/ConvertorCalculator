package com.sourceit.operators;

import com.sourceit.exceptions.WrongCalculationOperator;
import com.sourceit.models.Currency;

public interface StandardMathOperator {
    Currency eval(Currency cur1, Currency cur2) throws WrongCalculationOperator;
    Currency eval(Currency cur1, Double cur2) throws WrongCalculationOperator;
    Currency eval(Double cur1, Currency cur2) throws WrongCalculationOperator;
}

