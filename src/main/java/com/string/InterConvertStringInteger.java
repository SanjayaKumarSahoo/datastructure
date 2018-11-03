package com.string;

public class InterConvertStringInteger {

    public static void main(String[] args) {
        System.out.println(stringToInt("5555"));
        System.out.println(intToString(-123456));
    }

    private static int stringToInt(String data) {
        if (data == null || "".equals(data)) {
            throw new IllegalArgumentException("Invalid input");
        }

        double result = 0;
        char[] charData = data.toCharArray();

        int pow = 0;
        for (int i = charData.length - 1; i >= 0; i--) {
            result = result + Character.getNumericValue(charData[i]) * Math.pow(10, pow);
            pow++;
        }
        return (int) result;
    }

    private static String intToString(int data) {
        boolean isNegative = false;
        if (data < 0) {
            isNegative = true;
        }

        StringBuilder builder = new StringBuilder();
        do {
            builder.append((char) ('0' + Math.abs(data % 10)));
            data = data / 10;
        } while (data != 0);

        if (isNegative) {
            builder.append("-");
        }
        return builder.reverse().toString();

    }
}
