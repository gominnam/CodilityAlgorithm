package LeetCode.Array.medium;

import java.util.Arrays;

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for(int i=0; i<bookings.length; i++){
            int first = bookings[i][0] - 1;
            int last = bookings[i][1] - 1;
            int seats = bookings[i][2];

            for(int j=first; j<=last; j++){
                answer[j] += seats;
            }
        }

        return answer;
    }

    public int[] corpFlightBookings_optimization(int[][] bookings, int n) {
        int[] answer = new int[n + 1];
        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1];
            int seats = booking[2];

            answer[first] += seats;
            if (last < n) {
                answer[last] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }

        return Arrays.copyOf(answer, n);
    }

    public static void main(String[] args) {
        CorporateFlightBookings cfb = new CorporateFlightBookings();
        int[][] bookings = new int[][] {{1,2,10}, {2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(Arrays.toString(cfb.corpFlightBookings_optimization(bookings, n)));
    }
}

/*

Thinking:
1) corpFlightBookings 단순한 풀이법
- 시간복잡도 O(M * N)이 나온다. 정답은 되지만 요구하는 풀이법은 아니다.

2) corpFlightBookings_optimization 최적화 풀이법
- 시간복잡도 O(M + N)으로 시간복잡도 개선
- 차분 배열(Difference Array) 이라는 기법
- first 인덱스에는 seats 값을 더하고, last 인덱스에는 seats 값을 빼준다.
- 마지막에는 누적합을 순회하여 계산한다.

-ref: https://leetcode.com/problems/corporate-flight-bookings/

 */
