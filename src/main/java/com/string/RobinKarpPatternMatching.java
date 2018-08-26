package com.string;


public class RobinKarpPatternMatching {


    public static boolean patternRobinKarpMatching(String input, String pattern) {

        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Input should not be empty");
        }

        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern should not be empty");
        }

        return false;


    }

}
