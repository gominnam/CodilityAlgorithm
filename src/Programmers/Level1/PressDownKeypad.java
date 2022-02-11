package Programmers.Level1;

import java.util.*;

public class PressDownKeypad {
    public static String solution(int[] numbers, String hand){
        String answer = "";
        int[][] keyPad = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 1}};
        int[] left = {3, 0};
        int[] right = {3, 2};
        for(int i=0; i<numbers.length; i++){
            int[] tmp;

            if(numbers[i] == 0)
                tmp = keyPad[9];
            else {
                tmp = keyPad[numbers[i]-1];
            }

            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                left[0] = tmp[0];
                left[1] = tmp[1];
                continue;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right[0] = tmp[0];
                right[1] = tmp[1];
                continue;
            }

            int L = Math.abs(tmp[0] - left[0]) + Math.abs(tmp[1] - left[1]);
            int R = Math.abs(tmp[0] - right[0]) + Math.abs(tmp[1] - right[1]);
            if(L > R){
                answer += "R";
                right[0] = tmp[0];
                right[1] = tmp[1];
            }
            else if(L < R) {
                answer += "L";
                left[0] = tmp[0];
                left[1] = tmp[1];
            }
            else {
                if(hand.equals("right")){
                    answer += "R";
                    right[0] = tmp[0];
                    right[1] = tmp[1];
                }
                else{
                    answer += "L";
                    left[0] = tmp[0];
                    left[1] = tmp[1];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(numbers, hand);

        System.out.println(result);
    }
}

//result = "LRLLLRLLRRL"
/*
Level 1
코딩테스트 연습
2020 카카오 인턴십
키패드 누르기
 */
