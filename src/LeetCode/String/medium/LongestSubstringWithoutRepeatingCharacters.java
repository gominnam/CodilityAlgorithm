package LeetCode.String.medium;


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        return calculator(s);
    }

    public int calculator(String s) {
        int answer = 0;
        boolean[] isContain = new boolean[128];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (isContain[ch]) {
                isContain[s.charAt(left)] = false;
                left++;
            }
            isContain[ch] = true;
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }

    public int lengthOfLongestSubstring_solution(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(a.lengthOfLongestSubstring("dvdf"));//3
        System.out.println(a.lengthOfLongestSubstring("nfbmpabaprknhchdzzax"));//8

        System.out.println(a.lengthOfLongestSubstring_solution("pwwkew"));//3
        System.out.println(a.lengthOfLongestSubstring_solution("dvdf"));//3
        System.out.println(a.lengthOfLongestSubstring_solution("nfbmpabaprknhchdzzax"));//8
    }
}

/*

Thinking:
- Two pointer로 계산하여 최대값을 구함
- 알파벳이 아닌 공백, 특수문자가 포함된 경우이기 때문에 128개의 배열(아스키코드)을 사용
- HashSet 자료구조를 사용하여 중복된 문자를 체크 쉽게 풀 수 있다.

-ref: https://leetcode.com/problems/longest-substring-without-repeating-characters/

 */