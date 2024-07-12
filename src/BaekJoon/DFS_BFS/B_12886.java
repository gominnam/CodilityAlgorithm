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
        boolean[][] visit = new boolean[1501][1501];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[A][B] = true;
        q.offer(new int[] { A, B, C });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == cur[1] && cur[1] == cur[2]) {
                return 1;
            }

            for (int i = 0; i < 3; i++) {
                int ni = (i + 1) % 3;
                if (cur[i] != cur[ni]) {
                    int[] next = cur.clone();
                    if (cur[i] > cur[ni]) {
                        next[i] -= next[ni];
                        next[ni] *= 2;
                    } else {
                        next[ni] -= next[i];
                        next[i] *= 2;
                    }

                    if(visit[next[0]][next[1]]) continue;
                    visit[next[0]][next[1]] = true;
                    q.offer(next);
                }
            }
        }

        return 0;
    }
}

/*

TEST CASE:
1)
3 7 14

==> 1

2)
1 1 2

==> 0

3)
305 379 84

==> 1

 */