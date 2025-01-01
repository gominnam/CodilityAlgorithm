package LeetCode.HashTable.medium;

import java.util.Hashtable;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        Hashtable<Character, Integer> hashTable = new Hashtable<>();
        for(char c : s.toCharArray()){
            hashTable.put(c, hashTable.getOrDefault(c, 0)+1);
        }

        int answer = 0;
        for(char c : t.toCharArray()){
            int curValue = hashTable.getOrDefault(c, 0);
            if(curValue != 0){
               hashTable.put(c, curValue-1);
               continue;
            }
            answer++;
        }

        return answer;
    }

    public int minSteps2(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int answer = 0;
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] > 0) {
                count[c - 'a']--;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MinimumNumberOfStepsToMakeTwoStringsAnagram m = new MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(m.minSteps2("leetcode", "practice")); // 5
        System.out.println(m.minSteps2("anagram", "mangaar")); // 0
        System.out.println(m.minSteps2("xxyyzz", "xxyyzz")); // 0
    }
}

/*

:Thinking
- Hashtable로 풀었지만 alphabet 들만 들어오는 경우 배열을 사용하여 간단하게 해결하는게 쉽다.
- Hashtable 의 내부 구조 또한 배열 + 링크드리스트이기 때문에 hashcode() index가 충돌날 일이 없기 때문.

-ref: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

 */