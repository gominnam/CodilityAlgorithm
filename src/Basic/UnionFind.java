package Basic;

public class UnionFind {
    // 노드의 부모 노드를 찾는 getParent() 메서드 정의
    static int getParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = getParent(parent, parent[node]);
        return parent[node];
    }

    // Union-Find 알고리즘 예제
    static void unionFind(int n, int[][] edges) {
        // 부모 노드를 저장하는 배열 선언 및 초기화
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 모든 간선을 순회하면서 Union 연산 수행
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int parentA = getParent(parent, a);
            int parentB = getParent(parent, b);
            if (parentA != parentB) {
                parent[parentB] = parentA;
            }
        }

        // 각 노드의 부모 노드를 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + "의 부모 노드: " + getParent(parent, i));
        }
        int a = 1;
    }

    // Union-Find 알고리즘 예제 실행
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {2, 5}};
        unionFind(n, edges);
    }
}
/*
UnionFind Algorithm

- UnionFind 알고리즘은 서로소 집합을 관리하는 알고리즘으로, 노드들 간의 연결 상태를 나타내는 그래프에서
  노드들이 서로 같은 그룹에 속해있는지를 판별하기 위해 사용됩니다. UnionFind 알고리즘은 상호 배타인
  집합들로 분할되는 모든 원소에 대해, 서로소 집합들의 정보를 유지하고, 두 집합을 하나의 집합으로 합치거나,
  원소가 속한 집합을 찾는 기능을 수행합니다.


ref - chatGPT

 */