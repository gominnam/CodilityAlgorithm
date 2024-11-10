package LeetCode.BackTracking.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private static final String[] DIGIT_LETTERS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()) { // null 조건문 추가 안정성
            return result;
        }
        dfs(0, digits, new StringBuilder(), result);
        return result;
    }

    public void dfs(int level, String digits, StringBuilder current, List<String> result){
        if(level == digits.length()){
            result.add(current.toString());
            return;
        }
        String letters = DIGIT_LETTERS[digits.charAt(level) - '0'];
        for(char letter : letters.toCharArray()){
            current.append(letter);
            dfs(level+1, digits, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber a = new LetterCombinationsOfPhoneNumber();
        System.out.println(a.letterCombinations("23"));
    }
}

/*

[ 개선 ]

1. null 조건문 추가
: digits가 null인 경우에 대한 예외처리를 추가

2. StringBuilder를 사용하여 문자열을 조작
: 문자열을 조작할 때 StringBuilder를 사용하여 시간 효율성 단축

-ref: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 */