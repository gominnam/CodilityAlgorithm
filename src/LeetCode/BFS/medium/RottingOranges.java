package LeetCode.BFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    static final int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        boolean isRotten = false;
        boolean isFresh = false;
        Queue<Node> rottenPos = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    isFresh = true;
                }
                if(grid[i][j] == 2){
                    rottenPos.add(new Node(i, j));
                    isRotten = true;
                }
            }
        }

        if(!isRotten) {
            if(isFresh) return -1;
            return 0;
        }

        int result = bfs(grid, rottenPos);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return result;
    }

    public int bfs(int[][] grid, Queue<Node> rQueue){
        int result = 0;

        while (!rQueue.isEmpty()) {
            int size = rQueue.size();

            boolean flag = false;
            for(int i=0; i<size; i++){
                Node curNode = rQueue.poll();
                for(int j=0; j<4; j++){
                    int nx = curNode.x + mv[j][0];
                    int ny = curNode.y + mv[j][1];
                    if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                    if(grid[nx][ny] != 1) continue;
                    rQueue.add(new Node(nx, ny));
                    grid[nx][ny] = 2;
                    flag = true;
                }
            }

            if(flag)result++;
        }

        return result;
    }

    public static void main(String[] args){
        RottingOranges ro = new RottingOranges();
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};
        System.out.println(ro.orangesRotting(grid));
    }
}

/*

Thinking:

1. [[0]] -> 0
2. [[1]] -> -1



-ref: https://leetcode.com/problems/rotting-oranges/submissions/1451694193/

 */