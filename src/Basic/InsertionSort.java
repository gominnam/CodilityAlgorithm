package Basic;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {5, 1, 2, 3, 6, 9, 8, 4, 7};
        int[] tmp = insertionSort(arr);

        for(int x : tmp) System.out.print(x + " ");
    }

    public static int[] insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
                --j;
            }
        }

        return arr;
    }
}
/*
    ## 삽입정렬(시간복잡도( 최선의 경우 : O(N), 최악의 경우 O(N^2))

 */
