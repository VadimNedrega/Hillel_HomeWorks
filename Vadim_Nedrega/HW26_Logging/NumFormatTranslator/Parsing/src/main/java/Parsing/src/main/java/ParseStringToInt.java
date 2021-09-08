package Parsing.src.main.java;

import java.text.ParseException;

public class ParseStringToInt {
    public int parseInt(String str) throws ParseException {

        int number = 0;
        int i = 0;
        boolean isNegative = false;

        if (str.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (str.charAt(0) == '+') i++;

        for (int j = i; j < str.length(); j++) {

            int value = str.charAt(j) - '0';
            number *= 10;
            number += value;
        }
        if (isNegative) number = -number;
        return number;
    }
}
