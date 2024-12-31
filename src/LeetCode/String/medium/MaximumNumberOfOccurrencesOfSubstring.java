package LeetCode.String.medium;

import java.util.*;

public class MaximumNumberOfOccurrencesOfSubstring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int answer = 0;

        Map<String, Integer> map = new HashMap();
        for(int i=0; i<=s.length()-minSize; i++){
            String minString = s.substring(i, i+minSize);
            map.put(minString, map.getOrDefault(minString, 0)+1);
            String maxString = "";
            if(i+maxSize < s.length() && maxSize != minSize){
                maxString = s.substring(i, i+maxSize);
                map.put(maxString, map.getOrDefault(maxString, 0)+1);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            Set<Character> uniqueAlphabets = new HashSet<>();
            for(char c : entry.getKey().toCharArray()){
                uniqueAlphabets.add(c);
            }
            if(uniqueAlphabets.size() <= maxLetters){
                answer = Math.max(answer, entry.getValue());
            }
        }

        return answer;
    }

    public int maxFreq_2(String s, int maxLetters, int minSize, int maxSize) {
        int[] cnt = new int[26];
        Map<String, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0, result = 0;

        while (r < s.length()) {
            char c = s.charAt(r++);
            if (cnt[c - 'a'] == 0) {
                max++;
            }
            cnt[c - 'a']++;

            if (r - l < minSize) continue;
            if (r - l > minSize) {
                char t = s.charAt(l);
                cnt[t - 'a']--;
                if (cnt[t - 'a'] == 0) {
                    max--;
                }
                l++;
            }

            if (max <= maxLetters) {
                String tmp = s.substring(l, r);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                result = Math.max(map.get(tmp), result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfOccurrencesOfSubstring mnoos = new MaximumNumberOfOccurrencesOfSubstring();
        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
//        String s = "aaaa";
//        int maxLetters = 1;
//        int minSize = 3;
//        int maxSize = 3;
        System.out.println(mnoos.maxFreq_2(s, maxLetters, minSize, maxSize)); // 2
    }
}

/*

:Thinking
- HashMap, Set 자료구조 활용
- Iterator 사용법 다시 숙지

-ref: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

 */