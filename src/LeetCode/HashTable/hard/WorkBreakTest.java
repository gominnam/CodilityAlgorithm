package LeetCode.HashTable.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkBreakTest {

    public List<String> wordBreak(String s, List<String> wordDict){
        return dfs(s, wordDict, new HashMap<>(), 0);
    }

    public List<String> dfs(String s, List<String> wordDict, HashMap<Integer, List<String>> cache, int start){
        if(cache.containsKey(start)) {
            return cache.get(start);
        }

        List<String> result = new ArrayList<>();
        if(s.length() == start){
            result.add("");
            return result;
        }

        for(String word : wordDict){
            if(s.startsWith(word, start)) {
                List<String> subList = dfs(s, wordDict, cache, start + word.length());
                for(String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        cache.put(start, result);
        return result;
    }

    public static void main(String[] args){
        WorkBreakTest wb = new WorkBreakTest();
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
//        String s = "pineapplepenapple";
//        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wb.wordBreak(s, wordDict)); // ["cats and dog", "cat sand dog"]
    }
}
