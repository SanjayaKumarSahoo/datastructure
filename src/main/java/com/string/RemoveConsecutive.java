package com.string;


public class RemoveConsecutive {

    public static void main(String[] args) {
        String data = "mxabbachhcllo";
        System.out.println(removeConsecutive(data));
    }

    private static String removeConsecutive(String data) {
        char[] charArray = data.toCharArray();
        int j = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i + 1]) {
                charArray[j] = charArray[i];
                j = j + 1;
            }
        }
        charArray[j++] = charArray[charArray.length - 1];
        String result = "";
        for (int i = 0; i < j; i++) {
            result = result + charArray[i];
        }
        return result;
    }
}
