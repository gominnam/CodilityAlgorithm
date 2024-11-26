package LeetCode.HashTable.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>(), 0);
    }

    private List<String> dfs(String s, List<String> wordDict, Map<Integer, List<String>> memo, int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, start)) { // start 위치부터 시작하는 부분이 word와 같은지 확인
                List<String> sublist = dfs(s, wordDict, memo, start + word.length());
                for (String sub : sublist) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub); // empty인 경우는 남은 문자가 있고, 포함된 단어가 없을 경우
                }
            }
        }

        memo.put(start, result);
        return result;
    }

    public static void main(String[] args){
        WordBreakII wb = new WordBreakII();
//        String s = "catsanddog";
//        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wb.wordBreak(s, wordDict)); // ["cats and dog", "cat sand dog"]
    }
}

/*

-ref: https://leetcode.com/problems/word-break-ii/

 */
