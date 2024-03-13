package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        String[] arr = board.split("\\.", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() % 2 != 0) {
                System.out.println(-1);
                return;
            }
            int cnt = arr[i].length() / 4;
            sb.append("AAAA".repeat(cnt));
            sb.append("B".repeat(arr[i].length() % 4));
            if (i != arr.length - 1) {
                sb.append(".");
            }
        }
        System.out.println(sb.toString());
    }
}

/*

board.split("\\.", -1);
-1을 넣어주면 구분자가 문자열 끝에 위치할 경우에도 빈 문자열을 결과 배열에 포함시키라는 것입니다.

TESTCASE:
XXXX.

==>
AAAA.

 */