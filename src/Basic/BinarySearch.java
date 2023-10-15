package Basic;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {17, 28, 43, 67, 88, 92, 100};
        int ret = binarySearch(arr, 40);
        System.out.println(ret);
    }

    public static int binarySearch(int[] arr, int x){
        int lo = 0, hi = arr.length-1;
        while(lo+1 < hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] < x) lo = mid;
            else hi = mid;
        }

        return arr[hi];
    }
}
/*
Binary Search (이진탐색)

정렬된 배열에서 특정 값의 인덱스를 찾는 방법

 */