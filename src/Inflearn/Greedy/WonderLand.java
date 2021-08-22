package Inflearn.Greedy;

import java.util.*;

public class WonderLand {
    static int n, m;
    static int[] unf;

    static class Edge implements Comparable<Edge>{
        public int v1;
        public int v2;
        public int cost;
        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public static int Find(int a){
        if(unf[a] == a) return a;
        else return unf[a] = Find(unf[a]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args){
        WonderLand T = new WonderLand();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Edge> edge = new ArrayList<>();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edge.add(new Edge(a, b, c));
        }
        int answer = 0;
        int cnt = 0;
        Collections.sort(edge);
        for(Edge e : edge){
            if(cnt == n-1) break; //for문 수가 많을 때
            int f1 = Find(e.v1);
            int f2 = Find(e.v2);
            if(f1 != f2) {
                answer += e.cost;
                Union(e.v1, e.v2);
                cnt++;
            }
        }

        System.out.println(answer);
    }
}

/*
최소스패닝트리 : 크루스칼, Union&Find 활용(최소 값으로 모든 노드 연결하기)

설명

원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.

원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

아래의 그림은 그 한 예를 설명하는 그림이다.

Image1.jpg

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.


입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.

다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.

이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.


출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.

TEST CASE:
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

==> 196
 */