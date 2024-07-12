package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class B_12886 {
    static int A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        boolean[][] visit = new boolean[3][1501];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[0][A] = true;
        visit[1][B] = true;
        visit[2][C] = true;
        q.offer(new int[] { A, B, C });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == cur[1] && cur[1] == cur[2]) {
                return 1;
            }

            for (int i = 0; i < 3; i++) {
                int ni = (i + 1) % 3;
                if (cur[i] != cur[ni]) {
                    if (cur[i] > cur[ni]) {
                        cur[i] -= cur[ni];
                        cur[ni] *= 2;
                    } else {
                        cur[ni] -= cur[i];
                        cur[i] *= 2;
                    }

                    if (visit[0][cur[0]] && visit[1][cur[1]] && visit[2][cur[2]]) {
                        continue;
                    }

                    visit[0][cur[0]] = true;
                    visit[1][cur[1]] = true;
                    visit[2][cur[2]] = true;
                    q.offer(cur);
                }
            }
        }

        return 0;
    }
}
/*

-ref: https://www.acmicpc.net/source/41662151

TEST CASE:
1)
3 7 14

==> 1

2)
1 1 2

==> 0

 */