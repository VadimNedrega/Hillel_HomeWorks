package Parsing.src.main.java;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        ParseStringToInt parseStringToInt = new ParseStringToInt();
        System.out.println(parseStringToInt.parseInt("-445"));
    }
}
