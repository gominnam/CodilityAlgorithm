package LeetCode.String.medium;


public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int answer = calculator(s);
        return Math.max(answer, calculator(new StringBuilder(s).reverse().toString()));
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

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(a.lengthOfLongestSubstring("dvdf"));//3
        System.out.println(a.lengthOfLongestSubstring("nfbmpabaprknhchdzzax"));//8
    }
}

/*

Thinking:
- Two pointer로 정방향, 역방향 두번 계산하여 최대값을 구함
- 알파벳이 아닌 공백, 특수문자가 포함된 경우이기 때문에 128개의 배열(아스키코드)을 사용


-ref: https://leetcode.com/problems/longest-substring-without-repeating-characters/

 */