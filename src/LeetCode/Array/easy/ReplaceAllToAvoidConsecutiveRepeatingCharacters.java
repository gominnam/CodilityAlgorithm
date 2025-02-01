package LeetCode.Array.easy;

public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '?'){
               for(char ch = 'a'; ch <= 'z'; ch++){
                   if((i > 0 && sb.charAt(i-1) == ch) || (i < s.length() - 1 && s.charAt(i + 1) == ch)){
                       continue;
                   }
                   sb.setCharAt(i, ch);
                   break;
               }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceAllToAvoidConsecutiveRepeatingCharacters replaceAllToAvoidConsecutiveRepeatingCharacters = new ReplaceAllToAvoidConsecutiveRepeatingCharacters();
        String s = "ubv?w";
        System.out.println(replaceAllToAvoidConsecutiveRepeatingCharacters.modifyString(s));
    }
}

/*

Thinking:
- '?' 기준 양옆 char 가 같지 않아야 하는 문자로 String 수정하는 문제
- for 문법에서 char 변수를 사용하여 알파벳 접근하면 코드가 짧아진다.

-ref: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

 */