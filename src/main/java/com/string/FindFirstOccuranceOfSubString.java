package com.string;

public class FindFirstOccuranceOfSubString {

    public static void main(String[] args) {
        String sentence = "vcxvxc agood";
        String search = "good";
        System.out.println(findFirstOccurrence(sentence, search));
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
