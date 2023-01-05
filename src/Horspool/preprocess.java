package Horspool;

import java.util.HashMap;
import java.util.Map;

/**
 * This class computes the Bad Character Heuristic table, which is helpful in later steps to skip a lot of comparisons
 */
public class preprocess {

    public String pattern;
    public Map<Character,Integer> badMatchTable;

    public preprocess(String pattern){
        this.pattern = pattern;
        badMatchTable = generateBadMatchTable(pattern);
    }
    public Map<Character,Integer> generateBadMatchTable(String pattern) {
        int n = pattern.length();
        int tempVal;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n-2;i++){
            tempVal = n-i-1;
            map.put(pattern.charAt(i),tempVal);
        }
        if(n==2){
            map.put(pattern.charAt(0), n - 1);
        }
        map.put('*',n);
        if(map.containsKey(pattern.charAt(n-1))){
            return map;
        }
        else{
            map.put(pattern.charAt(n-1),n);
        }
        return map;
    }
}