package Inflearn.RecursiveTreeGraph;

import java.util.*;

public class SearchingCalf {
    boolean[] check = new boolean[20000];
    int[] move = {1, -1, 5};

    public int BFS(int n, int m){
        int L = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        while(!Q.isEmpty()){
            int len = Q.size(); //for문에서 Q.size() 사용하면 offer하므로 안에서 계속 돌게 된다.
            for(int i=0; i<len; i++){
                int cur = Q.poll();
                if(check[cur]) continue;
                check[cur] = true;
                for(int j=0; j<3; j++){
                    if(cur+move[j] == m) return L+1;
                    if(1 <= cur+move[j] && cur+move[j] <= 10000) Q.offer(cur+move[j]);
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args){
        SearchingCalf T = new SearchingCalf();

        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        int calf = sc.nextInt();

        System.out.println(T.BFS(pos, calf));
    }
}

/*
방문했던 것은 다시 넣지 않는다!! check 변수를 만들어야 함 [Time Limited Error 발생]
-1 이 있으므로 0보다 작을 때 예외처리 주의할것!!
 */