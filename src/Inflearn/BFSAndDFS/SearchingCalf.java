package Inflearn.BFSAndDFS;

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

송아지 찾기 1(BFS : 상태트리탐색)
설명

현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.

현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.

송아지는 움직이지 않고 제자리에 있다.

현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.

최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.


입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.


출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

TEST CASE:
5 14

=> 3
 */