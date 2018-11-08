package com.string;

public class ReverseAllWordsInSentence {

    public static void main(String[] args) {
        String sentence = "Hi I am good hence d nnn,m ,nm,n,mn";
        System.out.println(reverseAllWords(sentence));
    }

    private static String reverseAllWords(String sentence) {

        if (sentence == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        char[] charArray = sentence.toCharArray();
        int i = 0;
        for (int k = 0; k < charArray.length; k++) {
            if (charArray[k] == ' ') {
                reverse(i, k - 1, charArray);
                i = k + 1;
            }
            // handling last word
            if (k == charArray.length - 1) {
                reverse(i, charArray.length - 1, charArray);
            }
        }
        return new String(charArray);
    }

    private static void reverse(int start, int last, char[] data) {
        while (start < last) {
            char temp = data[start];
            data[start] = data[last];
            data[last] = temp;
            start++;
            last--;
        }
    }
}