package com.sourceit.calculation;


import com.sourceit.exceptions.ConversionException;
import com.sourceit.exceptions.WrongCalculationOperator;
import com.sourceit.functions.ConversionImpl;
import com.sourceit.models.Currency;
import com.sourceit.operators.*;

import java.util.LinkedList;

public class PolishStrategy {

    static boolean isDelim(char c) { // тру если пробел
        return c == ' ';
    }
    static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    static boolean isNotCurrency(char c) {
        return isOperator(c) || c == '(' || c == ')' || c == ' ';

    }

    static int priority(char op) {
        switch (op) { // при + или - возврат 1, при * / 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Object> st, char op) throws WrongCalculationOperator {
        Object r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        Object l = st.removeLast(); // также
        switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
                st.add(calculate(r, l, new Addition()));
                break;
            case '-':
                st.add(calculate(r, l, new Subtraction()));
                break;
            case '*':
                st.add(calculate(r, l, new Multiplication()));
                break;
            case '/':
                st.add(calculate(r, l, new Division()));
                break;
        }
    }

    static Currency calculate(Object o1, Object o2, StandardMathOperator op) throws WrongCalculationOperator {
        if (o1 instanceof Currency && o2 instanceof Currency) {
            return op.eval((Currency) o1, (Currency) o2);
        }
        else if(o1 instanceof Double) {
            return op.eval((Double) o1, (Currency) o2);
        }
        return op.eval((Currency) o1, (Double) o2);
    }

    public static Object eval(String s) throws WrongCalculationOperator, ConversionException { // вводим выражение
        LinkedList<Object> st = new LinkedList<Object>(); // сюда наваливают цифры
        LinkedList<Character> op = new LinkedList<Character>(); // сюда опрераторы и st и op в порядке поступления

        for (int i = 0; i < s.length(); i++) { // парсим строку с выражением и вычисляем
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            String conversion = "";
            if(Character.isAlphabetic(s.charAt(i))) {
                while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                    conversion += s.charAt(i++);
                }
                op.add('(');
            } else if (c == ')') {
                while (op.getLast()  != '(') {
                    processOperator(st, op.removeLast());
                    // function()
                    st.add(new ConversionImpl().converting((Currency) st.get(i), conversion));
                }
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c)) {
                    processOperator(st, op.removeLast());
                }
                op.add(c);
            } else {
                String value = "";
                String type = "";
                while (i < s.length() && !isNotCurrency(s.charAt(i))) {
                    if (s.charAt(i) == '.' || Character.isDigit(s.charAt(i))) {
                        value += s.charAt(i++);
                    } else {
                        type += s.charAt(i++);
                    }
                }
                if (type.isEmpty()) {
                    Double operand = Double.parseDouble(value);
                    st.add(operand);
                } else {
                    Currency currency = new Currency(type, Double.parseDouble(value));
                    st.add(currency);
                }
                --i;
            }
        }

        while (!op.isEmpty()) {
            processOperator(st, op.removeLast());
        }
        return st.get(0);  // возврат результата
    }

    public static void main(String[] args) throws WrongCalculationOperator, ConversionException {
        System.out.println(eval("toDollar(5euro)"));
    }
}
