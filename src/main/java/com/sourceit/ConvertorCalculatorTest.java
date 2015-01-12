package com.sourceit;

import com.sourceit.calculation.PolishStrategy;
import com.sourceit.exceptions.ConversionException;
import com.sourceit.exceptions.WrongCalculationOperator;

import java.util.Scanner;

public class ConvertorCalculatorTest {
    public static void main(String[] args) {
        PolishStrategy polishStrategy = new PolishStrategy();
        Scanner scanner = new Scanner(System.in);
        String function = scanner.nextLine();

        try {
            System.out.println(polishStrategy.eval(function));
        } catch (WrongCalculationOperator wrongCalculationOperator) {
            wrongCalculationOperator.printStackTrace();
        } catch (ConversionException e) {
            e.printStackTrace();
        }
    }
}
