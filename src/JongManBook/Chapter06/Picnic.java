package JongManBook.Chapter06;

import java.io.*;
import java.util.StringTokenizer;

public class Picnic {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        for(int i=0; i<c; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] areFriends = new boolean[n][n];
            boolean[] taken = new boolean[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                areFriends[first][second] = true;
                areFriends[second][first] = true;
            }
            int ret = solve(areFriends, taken, n);
            bw.write(ret + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(boolean[][] areFriends, boolean[] taken, int n){
        int firstFree = -1;
        for(int i=0; i<n; i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }

        if(firstFree == -1) return 1;
        int ret = 0;
        for(int pairWith = firstFree+1; pairWith<n; ++pairWith){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += solve(areFriends, taken, n);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }
}
/*
TEST CASE: 첫번째 줄 TEST CASE 수 : c / 다음 N개의 줄은 학생수 n, 친구 쌍의 수 m / m의 수만큼 친구 쌍의 수 번호
3
2 1
0 1
4 6
0 1 1 2 2 3 3 0 0 2 1 3
6 10
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

==>
1
3
4
 */
