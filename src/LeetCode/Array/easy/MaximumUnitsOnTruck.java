package LeetCode.Array.easy;

import java.util.Arrays;

public class MaximumUnitsOnTruck {

    /*
    시간복잡도 O(n log n) : Arrays.sort
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        while(truckSize > 0 && idx < boxTypes.length){
            if(boxTypes[idx][0] > 0){
                answer += boxTypes[idx][1];
                boxTypes[idx][0]--;
                truckSize--;
            }
            else idx++;
        }
        return answer;
    }

    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        while(truckSize > 0 && idx < boxTypes.length){
            if(boxTypes[idx][0] <= truckSize){
                answer += (boxTypes[idx][1]*boxTypes[idx][0]);
                truckSize -= boxTypes[idx][0];
                idx++;
            }
            else {
                answer += (boxTypes[idx][1]*truckSize);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumUnitsOnTruck maximumUnitsOnTruck = new MaximumUnitsOnTruck();
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnitsOnTruck.maximumUnits2(boxTypes, truckSize)); // 8
    }
}

/*

Thinking:
- 이차원배열 Arrays.sort() 사용법
    Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
    이차원배열 내림차순


-ref: https://leetcode.com/problems/maximum-units-on-a-truck/description/

 */