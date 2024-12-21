package LeetCode.String.medium;


public class StringCompression {

    public int compress(char[] chars) { //todo: repeat gpt source
        int index = 0; // 압축문자를 저장할 pointer
        int i = 0; // 입력 배열을 순회하는 pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // 현재 문자의 연속된 개수를 셈
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // 현재 문자를 압축된 배열에 저장
            chars[index++] = currentChar;

            // 문자의 개수가 1보다 크면, 그 개수를 배열에 저장
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // 압축된 배열의 길이
    }

    // 신규 배열을 생성하여 요구사항 불만족.
    public int compress2(char[] chars) {
        int[] alphabetArray = new int[26];
        for(char c : chars){
            int idx = c - 'a';
            alphabetArray[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            char alphabet = (char)(i + 'a');
            int count = alphabetArray[i];
            if(count == 1) {
                sb.append(alphabet);
            }
            else if(count > 1) {
                sb.append(alphabet).append(alphabet);
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a', 'a', 'c', 'c', 'z', 'z', 'z'};
        System.out.println(sc.compress2(chars2)); // 6
    }
}

/*

-Thinking
: [요구사항 1] 문자열을 압축하는 문제 조건이 추가 Array를 생성하지 않고 구현해야한다.
: [요구사항 2] input 배열에 압축된 내용으로 수정하는 로직을 수행해야 한다.


-ref: https://leetcode.com/problems/string-compression/

 */