package com.string;

public class FindFirstOccuranceOfSubString {

    public static void main(String[] args) {
        String sentence = "vcxvxc agood";
        String search = "good";
        System.out.println(findFirstOccurrence(sentence, search));
        System.out.println(findFirstOccurrenceOtherMethod(sentence, search));
    }


    private static int findFirstOccurrenceOtherMethod(String sentence, String search) {
        if (sentence == null || sentence.length() == 0) {
            throw new RuntimeException("Invalid input");
        }
        if (search == null || search.length() == 0) {
            return -1;
        }
        char[] sentenceArray = sentence.toCharArray();
        char[] searchArray = search.toCharArray();

        for (int i = 0; i < sentenceArray.length; i++) {
            for (int j = 0; j < searchArray.length; j++) {
                if (sentenceArray[i] != searchArray[j]) {
                    continue;
                } else {
                    boolean isMatch = matchWords(i, sentenceArray, search);
                    if (isMatch) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean matchWords(int i, char[] sentenceArray, String search) {
        int j = 0;
        char[] searchArray = search.toCharArray();
        while (i < sentenceArray.length && j < searchArray.length) {
            if (sentenceArray[i] != searchArray[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }


    private static int findFirstOccurrence(String sentence, String search) {

        if (sentence == null || search == null) {
            throw new IllegalArgumentException("Invalid input.");
        }

        char[] sentenceCharArray = sentence.toCharArray();
        char[] searchCharArray = search.toCharArray();

        int i = 0;
        while (i < sentenceCharArray.length) {
            int k = 0;
            if (sentenceCharArray[i] == searchCharArray[k]) {
                boolean isMatch = false;
                while (k + 1 < searchCharArray.length && sentenceCharArray.length - i >= searchCharArray.length) {
                    if (sentenceCharArray[i + k + 1] == searchCharArray[k + 1]) {
                        isMatch = true;
                        k++;
                    } else {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
