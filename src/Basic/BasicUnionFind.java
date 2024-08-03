package Basic;

public class BasicUnionFind {
    private static int[] parent;

    public void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // Find parent node
    public int getParent(int k){
        if(parent[k] != k){
            parent[k] = getParent(parent[k]);
        }
        return parent[k];
    }

    // Initialization
    public void unionFind(int n){
        parent = new int[n + 1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }

    public static void main(String[] args){
        BasicUnionFind basicUnionFind = new BasicUnionFind();
        basicUnionFind.unionFind(6);
        basicUnionFind.union(1, 2);
        basicUnionFind.union(4, 5);
        basicUnionFind.union(5, 6);
        basicUnionFind.union(2, 5);
        for(int i=1; i<=6; i++){
            System.out.println("Node " + i + "'s parent node: " + basicUnionFind.getParent(i));
        }
    }
}
