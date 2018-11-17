package com.string;

public class SpreadSheetColumnEncoding {
    public static void main(String[] args) {
        System.out.println(constructFromBase(28, 26));

    }

    // encode spread sheet columns  ids to integers
    private static int spreadSheetEncoding(String col) {
        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }
        return result;
    }

    // decode spread sheet columns integer to ids
    private static String spreadSheetDecoding(int col) {
        return "";
    }

    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? "" : constructFromBase(numAsInt / base, base)
                + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
    }
}
