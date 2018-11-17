package com.string;

import java.util.ArrayList;
import java.util.List;

public class GetAllValidIp {

    public static void main(String[] args) {
        String input = "19216811";
        System.out.println(getAllValidIP(input));
    }

    private static List<String> getAllValidIP(String input) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < 4 && i < input.length(); i++) {
            String first = input.substring(0, i);
            if (isValidPart(first)) {
                for (int j = i; j < 4 && i + j < input.length(); j++) {
                    String second = input.substring(i, i + j);
                    if (isValidPart(second)) {

                    }
                }
            }
        }
        return result;
    }

    private static boolean isValidPart(String data) {
        return true;
    }
}
