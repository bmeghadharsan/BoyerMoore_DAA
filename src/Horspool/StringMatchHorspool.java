package Horspool;

import java.util.*;

public class StringMatchHorspool {
    public static List<Integer> patternMatch(String text, String pattern, Map<Character,Integer> badMatchTable) {
        List<Integer> solution = new ArrayList<>();
        int patternLength = pattern.length();
        int textLength = text.length();
        int count = 0;
        int i, j;
        Integer shift;
        for (i = patternLength - 1; i < textLength; shift = badMatchTable.get(text.charAt(i)),  i += shift != null? shift: patternLength ) {
            count++;
            for (j = 0; (j < patternLength) && (text.charAt(i - j) == pattern.charAt(patternLength - 1 - j)); j++,count++);
            if (j == patternLength){
                System.out.println("Found during comparison : "+(count-1));
                solution.add(i - patternLength + 1);}
        }
        System.out.println("Total Comparisons : "+count);
        return solution;
    }
}
