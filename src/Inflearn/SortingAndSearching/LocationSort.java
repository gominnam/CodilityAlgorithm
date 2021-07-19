package Inflearn.SortingAndSearching;

import java.util.*;

public class LocationSort {
    public int[][] Solve(int n, int[][] arr){
        for(int i=0; i<n; i++){

        }


        return arr;
    }

    public static void main(String[] args){
        LocationSort T = new LocationSort();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int[] i : T.Solve(n, arr)){
            for(int x : i){
                System.out.println(x + " ");
            }
            System.out.println();
        }
    }
}
