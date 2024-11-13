package LeetCode.HashTable.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){
            if(map.get(c) == null) return false;
            if(map.get(c) <= 0) return false;
            map.put(c, map.get(c)-1);
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        boolean flag = false;

        flag = Arrays.equals(array1,array2);
        return flag;
    }

    public static void main(String[] args){
        ValidAnagram va = new ValidAnagram();
        String s = "aacc", t = "ccac";
        System.out.println(va.isAnagram(s, t));
    }
}

/*

* isAnagram VS isAnagram2 VS isAnagram3
: 15ms 와 6ms 와 3ms 점차 속도 개선
: O(n) [ 실제론 O(2n) ] , O(n) [ 실제론 O(n) + O(26) ], O(NlogN) [ 실제 문자정렬 O(nlogn) * 2 + O(n) ]
: Linked 참조 접근 보다 Array 접근이 빠름.


-ref: https://leetcode.com/problems/valid-anagram/submissions/1449532344/

 */
