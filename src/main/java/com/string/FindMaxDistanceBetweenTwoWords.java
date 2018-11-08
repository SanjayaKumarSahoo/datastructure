package com.string;

public class FindMaxDistanceBetweenTwoWords {

    public static void main(String[] args) {
        System.out.println(distance("i am good got from something from nice s as " +
                "to sa aa giv0en to whole", "from", "to"));
    }

    private static int distance(String sentence, String from, String to) {
        String[] wordsArray = sentence.split(" ");
        int maxGap = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            int gap = 0;
            if (wordsArray[i].equals(from)) {
                for (int j = i + 1; j < wordsArray.length; j++) {
                    if (wordsArray[j].equals(to)) {
                        if (gap > maxGap) {
                            maxGap = gap;
                        }
                    }
                    gap++;
                }
            }
        }
        return maxGap;
    }
}
