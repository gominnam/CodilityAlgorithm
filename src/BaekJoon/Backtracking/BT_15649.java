package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_15649 {
    static int N, M;
    static int arr[];
    static boolean visited[];

    public static void dfs(int depth){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(0);
    }
}

/*

#, Backtracking 특징

1. 비선형 구조 탐색:
   - 백트래킹은 가능한 모든 해를 탐색하는 비선형 구조 탐색 방법입니다.
     문제의 해가 될 수 있는 모든 후보군을 시스템적으로 탐색하여 해를 찾습니다.
2. 재귀적 접근:
   - 대부분의 백트래킹 알고리즘은 재귀적인 접근 방식을 사용합니다.
     각 재귀 호출은 한 가지 선택을 시도하고, 이 선택이 불가능한 것으로 판단되면 재귀를 통해 이전 단계로 돌아갑니다.
3. 가지치기(Pruning):
   - 탐색 과정에서 해가 될 수 없는 경우(즉, 문제의 조건을 만족하지 않는 경우)는 더 이상 그 경로를 따라가지 않고, 다른 경로를 시도합니다.
     이 과정을 가지치기라고 하며, 탐색의 효율성을 높입니다.



위의 문제는 중복되는 수열도 출력되는 문제 중복 제거 문제는 15650 참고
TESTCASE:
4 2

==>
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
 */