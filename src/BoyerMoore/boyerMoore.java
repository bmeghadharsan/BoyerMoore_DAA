package BoyerMoore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class implements patter searching algorithm , both Naive and Boyer Moore implementation
 * @author meghadharsan
 */
public class boyerMoore {
    public static List<Integer> solve(String pattern, String input, Map<Character,Map<Integer,Integer>> badCharacterHeuristicTable){
        System.out.println("____________________________________");
        int comparisonCount = 0;
        Integer badCharacterHeuristicValue;
        int n = pattern.length(), m = input.length();
        List<Integer> matches = new ArrayList<>();
        int fromIndex = 0;
        while (fromIndex + (n - 1) < m) {
            for (int indexInPattern = n - 1; indexInPattern >= 0; indexInPattern--) {
                int indexInText = fromIndex + indexInPattern;
                char x = input.charAt(indexInText);
                char y = pattern.charAt(indexInPattern);
                System.out.println("Indexes being compared(index[text],index[patter]) : "+indexInText+"["+x+"]"+", "+indexInPattern+"["+y+"]");
                System.out.println(input);
                for(int i=0;i<fromIndex;i++){
                    System.out.print(" ");
                }
                System.out.println(pattern);
                System.out.println("____________________________________");
                comparisonCount++;
                if (x != y) {
                    System.out.println("Mismatch Occurred");
                    System.out.println("____________________________________");
                    badCharacterHeuristicValue = null;
                    if(badCharacterHeuristicTable.containsKey(x) && badCharacterHeuristicTable.get(x).containsKey(indexInPattern))
                        badCharacterHeuristicValue = badCharacterHeuristicTable.get(x).get(indexInPattern);
                    if (badCharacterHeuristicValue == null) {
                        System.out.println("'"+x+"' not found in pattern,Hence skipping throughout");
                        System.out.println("____________________________________");
                        fromIndex = indexInText + 1;
                    } else {
                        int shift = indexInText - (fromIndex + badCharacterHeuristicValue);
                        if(shift>0)
                            fromIndex+=shift;
                        else
                            fromIndex+=1;
                    }
                    break;
                } else if (indexInPattern == 0) {
                    System.out.println("⭐⭐⭐Successfully found a Match⭐⭐⭐");
                    System.out.println("Comparison count : "+comparisonCount);
                    System.out.println("____________________________________");
                    matches.add(fromIndex);
                    fromIndex++;
                }
            }
        }
        System.out.println("Total comparisons made : "+comparisonCount);
        return matches;
    }

    public static Integer naiveSolve(String pattern, String input){
        int inputLength = input.length();//length of the text
        int patternLength = pattern.length();//length of the pattern;
        int count = 0;
        for(int i=0;i<inputLength-patternLength+1;i++){
            int j=0;
            if(j>=patternLength)
                break;
            while(j < patternLength){
                count++;
                if(input.charAt(i+j) == pattern.charAt(j)){
                    j++;
                }
                else{
                    break;
                }

            }
            if(j == patternLength){
                System.out.println("Match found at index : "+i);
            }
        }
        if(count==0)
            System.out.println("Pattern not found");
        return count;
    }
}
//    public static List<Integer> solve(String pattern, String input, Map<Character,Integer> skipTable){
//        int comparisonCount = 0;
//        int n = pattern.length(), m = input.length();
//        List<Integer> matches = new ArrayList<>();
//        int fromIndex = 0;
//        while (fromIndex + (n - 1) < m) {
//            for (int indexInPattern = n - 1; indexInPattern >= 0; indexInPattern--) {
//                int indexInText = fromIndex + indexInPattern;
//                char x = input.charAt(indexInText);
//                char y = pattern.charAt(indexInPattern);
//                System.out.println("Indexes being compared(index[text],index[patter]) : "+indexInText+"["+x+"]"+", "+indexInPattern+"["+y+"]");
//                System.out.println(input);
//                for(int i=0;i<fromIndex;i++){
//                    System.out.print(" ");
//                }
//                System.out.println(pattern);
//                System.out.println("____________________________________");
//                comparisonCount++;
//                if (x != y) {
//                    System.out.println("Mismatch Occurred");
//                    System.out.println("____________________________________");
//                    Integer skipValue = skipTable.get(x);
//                    if (skipValue == null) {
//                        System.out.println("'"+x+"' not found in pattern,Hence skipping throughout");
//                        System.out.println("____________________________________");
//                        fromIndex = indexInText + 1;
//                    } else {
//                        int shift = indexInText - (fromIndex + skipValue);
//                        System.out.println("Shift : "+shift+" skipValue : "+skipValue+" fromIndex "+fromIndex );
//                        if(shift>0)
//                            fromIndex+=shift;
//                        else
//                            fromIndex+=1;
//                        System.out.println("New from Index : "+fromIndex);
//                    }
//                    break;
//                } else if (indexInPattern == 0) {
//                    System.out.println("⭐⭐⭐Successfully found a Match⭐⭐⭐");
//                    System.out.println("____________________________________");
//                    matches.add(fromIndex);
//                    fromIndex++;
//                }
//            }
//        }
//        System.out.println("Total comparisons made : "+comparisonCount);
//        return matches;
//    }