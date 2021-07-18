package Inflearn.SortingAndSearching;

import java.util.*;

public class Mischievous {
    public ArrayList<Integer> Solve(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone(); // 깊은 복사
        Arrays.sort(tmp);
        for(int i=0; i<n; i++){
            if(arr[i] != tmp[i]) answer.add(i+1);
        }

        return answer;
    }

    public static void main(String[] args){
        Mischievous T = new Mischievous();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i : T.Solve(n, arr)){
            System.out.print(i + " ");
        }
    }
}
