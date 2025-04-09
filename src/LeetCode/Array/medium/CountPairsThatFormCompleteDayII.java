package LeetCode.Array.medium;

import java.util.HashMap;
import java.util.Map;

public class CountPairsThatFormCompleteDayII {

    public long countCompleteDayPairs(int[] hours) {
        long[] remains = new long[24];
        for(int hour : hours){
            int remain = hour % 24;
            remains[remain]++;
        }
        long count = 0;
        count = remains[0] * (remains[0]-1) / 2;
        count = count + remains[12] * (remains[12]-1) / 2;
        int left = 1, right = remains.length - 1;
        while(left < right){
            count += remains[left] * remains[right];
            left++;
            right--;
        }
        return count;
    }

    public long countCompleteDayPairs_map(int[] hours) {
        Map<Integer, Long> remainderCount = new HashMap<>();
        long count = 0;

        for (int hour : hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24; // 한번더 나누는 이유는 0인경우

            // 현재 remainder의 보완 값(complement)이 이미 존재하면 쌍을 형성
            count += remainderCount.getOrDefault(complement, 0L);

            // 현재 remainder 값을 맵에 추가
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0L) + 1);
        }

        return count;
    }

    public long countCompleteDayPairs_optimized(int[] hours) {
        long ans = 0;
        int[] count = new int[24];

        for (int i = 0; i < hours.length; i++) {
            ans += count[(24 - hours[i] % 24) % 24];
            count[hours[i] % 24]++;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountPairsThatFormCompleteDayII cp = new CountPairsThatFormCompleteDayII();
        int[] hours = {12,12,30,24,24};
        System.out.println(cp.countCompleteDayPairs(hours)); // 2
    }
}

/*


이전에 등장한 값들만을 고려해도 되는 이유는 문제의 특성상 쌍(pair)을 형성하는 조건이기 때문.

 */

