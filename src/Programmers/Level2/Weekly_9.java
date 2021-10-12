package Programmers.Level2;

public class Weekly_9 {
    static int[] parent;

    public static void main(String[] args){
        /*int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};*/

        int n = 2;
        int[][] wires = {{1,2}};

        int a = solution(n, wires);

    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;//절대값 차이 최소
        parent = new int[n+1];

        for(int i=0; i<wires.length; i++){
            for(int p=0; p<n+1; p++){
                parent[p] = p;
            }

            for(int j=0; j<wires.length; j++){
                if(i==j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                unionParent(a, b);
            }

            int tmp = 0;
            for(int k=1; k<n+1; k++){
                if(findParent(1, k)) tmp++;
            }
            answer = Math.min(answer, Math.abs((n - tmp) - tmp));
        }

        return answer;
    }

    public static int getParent(int a){
        if(parent[a] == a) return parent[a];
        return parent[a] = getParent(parent[a]);
    }

    public static boolean findParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return true;
        return false;
    }

    public static void unionParent(int a, int b){
        int pa = getParent(a);
        int pb = getParent(b);
        if(pa < pb) parent[b] = pa;
        else parent[a] = pb;
    }
}
