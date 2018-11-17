package com.string;


public class RobinKarpPatternMatching {


    public static void main(String[] args) {
        System.out.println(robinKarp("GACGCCA", "CGC"));
        System.out.println(robinKarp("GACGCCA", "CGCd"));
    }

    private static int robinKarp(String input, String pattern) {

        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Input should not be empty");
        }

        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern should not be empty");
        }

        long patternHash = generateHash(pattern);
        long subStringHash = 0;

        String prev = null;
        String next = null;

        for (int i = 0; i < input.length() && i + pattern.length() < input.length(); i++) {

            prev = next;
            next = input.substring(i, i + 3);


            // generate hash for first time
            if (i == 0) {
                subStringHash = generateHash(next);
            } else {
                subStringHash = generateRollingHash(subStringHash, prev, next);
            }

            if (patternHash == subStringHash) {
                if (matchCharacterByCharacter(next, pattern)) {
                    return i;
                }
            }

        }
        return -1;
    }


    private static boolean matchCharacterByCharacter(String subString, String pattern) {
        return subString.equals(pattern);
    }

    /**
     * rolling hash
     * [prev hash - (ascii of first character of prev) * 127^(pattern length - 1)]*127 + ascii next last character * 127^0
     */
    private static long generateRollingHash(long hash, String prev, String next) {
        int prevFirstCharAscii = (int) prev.toCharArray()[0];
        int nextLastCharAscii = (int) next.toCharArray()[next.length() - 1];
        return (hash - prevFirstCharAscii * (long) Math.pow(127, prev.length() - 1)) * 127 + (long) (nextLastCharAscii * Math.pow(127, 0));
    }

    /**
     * Total ASCII - 127
     * ASCII  - (A - Z) =  (65 - 90)
     * ASCII  - (a - 5) =  (97 - 122)
     * ASCII  - (0 - 9) =  (91 - 100)
     * hash function for ABC = 65*127^2+66*127^1+67*127^0
     */
    private static long generateHash(String data) {
        long hash = 0;
        char[] patternCharArray = data.toCharArray();
        for (int i = 0; i < patternCharArray.length; i++) {
            int ascii = (int) (patternCharArray[i]);
            hash = hash + ascii * (long) (Math.pow(127, patternCharArray.length - (i + 1)));
        }
        return hash;
    }
}
