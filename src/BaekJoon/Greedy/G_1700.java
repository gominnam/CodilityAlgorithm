package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class G_1700 {
    static int[] e; //equipment
    static int N, M;//총 수, 멀티텝 코드 수
    static boolean[] used;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        e = new int[N];
        used = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            e[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0, cnt = 0;
        while(true){
            if(M == cnt) break;
            if(!used[e[idx]]){
                used[e[idx]] = true;
                cnt++;
            }
            idx++;
        }
        while(idx < N){
            if(!used[e[idx]]){
                ArrayList<Integer> arr = new ArrayList<>();
                for(int i=idx; i<N; i++){
                    if(used[e[i]] && !arr.contains(e[i])) arr.add(e[i]);
                }

                if(arr.size() == M){
                    used[arr.get(arr.size()-1)] = false;
                }
                else{
                    for (int j = 1; j <= N; j++) {
                        if (used[j] && !arr.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }

                used[e[idx]] = true;
                ans++;
            }

            idx++;
        }

        System.out.println(ans);
    }
}
/*
    ## 멀티탭 스케줄링
 */
