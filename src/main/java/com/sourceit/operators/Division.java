package com.sourceit.operators;

import com.sourceit.exceptions.WrongCalculationOperator;
import com.sourceit.models.Currency;

public class Division implements StandardMathOperator {
    @Override
    public Currency eval(Currency cur1, Currency cur2) throws WrongCalculationOperator {
        throw new WrongCalculationOperator("Division cannot be done for Currency");
    }

    @Override
    public Currency eval(Currency cur1, Double cur2) throws WrongCalculationOperator {
        return new Currency(cur1.getType(), cur1.getValue() / cur2);
    }

    @Override
    public Currency eval(Double cur1, Currency cur2) throws WrongCalculationOperator {
        return eval(cur2, cur1);
    }
}
