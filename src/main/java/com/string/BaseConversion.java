package com.string;

public class BaseConversion {
    public static void main(String[] args) {
        System.out.println(baseConversion("615", 7, 13));
    }

    // numAsString is in base b1, convert it to base b2
    private static String baseConversion(String numAsString, int b1, int b2) {

        if (numAsString == null || "".equals(numAsString) || b1 == 0 || b2 == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        boolean isNegative = numAsString.charAt(0) == '-' ? true : false;

        char[] charArray = numAsString.toCharArray();

        // convert numAsString to decimal
        int sum = 0;
        int pow = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            sum = (int) (sum + Character.getNumericValue(charArray[i]) * Math.pow(b1, pow));
            pow++;
        }
        return isNegative ? "-" + constructFromBase(sum, b2) : constructFromBase(sum, b2);
    }


    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? "" : constructFromBase(numAsInt / base, base)
                + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
    }
}
