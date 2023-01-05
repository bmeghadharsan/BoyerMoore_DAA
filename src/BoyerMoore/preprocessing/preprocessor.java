package BoyerMoore.preprocessing;

import java.util.HashMap;
import java.util.Map;

/**
 * This class computes the Bad Character Heuristic table, which is helpful in later steps to skip a lot of comparisons
 */
public class preprocessor {

    public String pattern;
    public Map<Character,Map<Integer,Integer>> badCharacterHeuristic;

    public preprocessor(String pattern){
        this.pattern = pattern;
        badCharacterHeuristic = generateBadCharacterHeuristic(pattern);
    }
    public Map<Character,Map<Integer,Integer>> generateBadCharacterHeuristic(String pattern) {
        Map<Character,Map<Integer,Integer>> map = new HashMap<>();
        Map<Integer,Integer> subMap;
        for(int i=pattern.length()-1;i>=0;i--){
            if(map.containsKey(pattern.charAt(i))){
                subMap = map.get(pattern.charAt(i));
                subMap.put(i,(int)1e9);
                int k =i+1;
                while(subMap.get(k)==null){
                    subMap.put(k,i);
                    k++;
                }
                map.put(pattern.charAt(i),subMap);
            }
            else{
                subMap = new HashMap<>();
                subMap.put(i,(int)1e9);
                for(int j = i+1;j<pattern.length();j++){
                    subMap.put(j,i);
                }
            }
            map.put(pattern.charAt(i),subMap);
        }
        return map;
    }
}

//    public String pattern;
//    public Map<Character,Integer> skipTable;
//
//    public skipTableCreator(String pattern){
//        this.pattern = pattern;
//        skipTable = generateSkipTable(pattern);
//    }
//
//    public Map<Character, Integer> generateSkipTable(String pattern) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = pattern.length() - 1; i >= 0; i--) {
//            char c = pattern.charAt(i);
//            if (!map.containsKey(c))
//                map.put(c, i);
//        }
//        map.put('*',pattern.length());
//        return map;
//    }

//        for (int i = pattern.length() - 1; i >= 0; i--) {
//            char c = pattern.charAt(i);
//            if (!map.containsKey(c))
//                map.put(c, i);
//        }
//        map.put('*',pattern.length());
//        return map;
