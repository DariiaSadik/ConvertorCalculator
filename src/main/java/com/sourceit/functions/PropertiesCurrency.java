package com.sourceit.functions;

import java.io.*;
import java.util.*;

public class PropertiesCurrency {
    private String text;

    public void readFromFile(String path){
        try(BufferedReader  input = new BufferedReader(new FileReader(path))) {
            String str;
            text = "";
            while ((str = input.readLine()) != null){
                text += str;
            }
        } catch(IOException exc){
            exc.printStackTrace();
        }
    }

    public Map<LinkedList<String>, Map<String, Double>> parseString () {
        readFromFile("src/main/resources/functionality.txt");
        String[] line = text.split(";");
        Map<LinkedList<String>, Map<String, Double>> function = new HashMap<>();

        String[] items;
        String[] rate;

        String temp;
        for (int i = 0; i < line.length; i++){
            LinkedList<String> format = new LinkedList<>();
            Map<String, Double> rates = new HashMap<>();
            temp = line[i];
            items = temp.split(" ");
            format.add(items[0]);
            format.add(items[1]);
            for(int j = 2; j < items.length; j++){
                rate = items[j].split("=");
                rates.put(rate[0], Double.parseDouble(rate[1]));
            }
            function.put(format, rates);
        }
        return function;
    }
}
