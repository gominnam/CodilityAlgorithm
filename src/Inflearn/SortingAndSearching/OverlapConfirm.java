package Inflearn.SortingAndSearching;

import java.util.*;

public class OverlapConfirm {
    public String Solve(int n, int[] numbers){
        String answer = "U";
        Arrays.sort(numbers);
        for(int i=1; i<numbers.length; i++){
            if(numbers[i] == numbers[i-1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args){
        OverlapConfirm T = new OverlapConfirm();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        System.out.println(T.Solve(n, numbers));
    }
}
