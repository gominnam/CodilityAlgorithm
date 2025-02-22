package LeetCode.HashTable.medium;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        boolean[] cache = new boolean[strs.length];
        for(int i=0; i<strs.length; i++){
            if(cache[i]) continue;
            List<String> anagram = new ArrayList<>();
            anagram.add(strs[i]);
            int[] alphabet = new int[26];
            for(char c : strs[i].toCharArray()){
                alphabet[c -'a']++;
            }
            for(int j=i+1; j<strs.length; j++){
                if(strs[i].length() != strs[j].length() || cache[j]){
                    continue;
                }
                int[] cmpAlphabet = new int[26];
                for(char ch : strs[j].toCharArray()){
                    cmpAlphabet[ch - 'a']++;
                }

                boolean flag = true;
                for(int k=0; k<26; k++){
                    if(alphabet[k] != cmpAlphabet[k]) {
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    cache[j] = true;
                    anagram.add(strs[j]);
                }
            }
            answer.add(anagram);
        }

        return answer;
    }

    public List<List<String>> groupAnagrams_hashMap(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(a.groupAnagrams(strs));
        System.out.println(a.groupAnagrams_hashMap(strs));
    }
}

/*

Thinking;
- groupAnagrams(..) 메서드 구현으로 제출해서 통과했지만 사이트 결과: 415ms Beats 5.03%
- 최적화 알고리즘 개선이 필요

- groupAnagram_hashMap(..) 메서드 정렬하여 hashMap 자료구조 이용
- anagram은 보통 정렬하고 hashMap 자료구조를 이용하면 간단하다.
- map.values() 메서드는 map의 모든 값들을 Collection 형태로 반환한다.

-ref: https://leetcode.com/problems/group-anagrams/

 */