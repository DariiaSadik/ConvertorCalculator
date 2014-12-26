package com.sourceit.operators;

import com.sourceit.exceptions.WrongCalculationOperator;
import com.sourceit.models.Currency;

public class Subtraction implements StandardMathOperator {
    @Override
    public Currency eval(Currency cur1, Currency cur2) throws WrongCalculationOperator {
        if(!cur1.getType().equals(cur2.getType())){
            throw new WrongCalculationOperator("Different currencies cannot be subtracted") ;
        }
        return new Currency(cur1.getType(),cur2.getValue() - cur1.getValue());
    }

    @Override
    public Currency eval(Currency cur1, Double cur2) throws WrongCalculationOperator{
        throw new WrongCalculationOperator("Number cannot be subtracted from currency");
    }

    @Override
    public Currency eval(Double cur1, Currency cur2) throws WrongCalculationOperator{
        throw new WrongCalculationOperator("Currency cannot be subtracted from number");
    }
}
