package Programmers.Level2;

import java.util.*;

public class FindTheLargestNumberBehind {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer, -1);
        stack.push(0);
        for(int i=1; i<numbers.length; i++){
            while(!stack.isEmpty()){
                if(numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }else{
                    break;
                }
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args){
        FindTheLargestNumberBehind ftlnb = new FindTheLargestNumberBehind();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        for(int i : ftlnb.solution(numbers)){
            System.out.print(i + " ");
        }
    }
}
/*
Programmers 뒤에 있는 큰수 찾기

** feedback
2중 for문으로 한 경우 효율성테스트에서 마지막 4개의 case 실패

=> Stack structure



TEST CASE:
[2, 3, 3, 5]
=> [3, 5, 5, -1]

[9, 1, 5, 3, 6, 2]
=>[-1, 5, 6, 6, -1, -1]

 */