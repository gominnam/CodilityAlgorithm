package LeetCode.HashTable.medium;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(a.groupAnagrams(strs));
    }
}

/*

Thinking;
- groupAnagrams 메서드 구현으로 제출해서 통과했지만 사이트 결과: 415ms Beats 5.03%
- 최적화 알고리즘 개선이 필요

-ref: https://leetcode.com/problems/group-anagrams/

 */