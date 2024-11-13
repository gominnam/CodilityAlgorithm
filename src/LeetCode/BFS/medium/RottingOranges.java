package LeetCode.BFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;

            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int nx = point.x + direction[0];
                    int ny = point.y + direction[1];

                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.add(new Point(nx, ny));
                        freshOranges--;
                        hasRotten = true;
                    }
                }
            }

            if (hasRotten) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args){
        RottingOranges ro = new RottingOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
//        int[][] grid = {{0,2}};
        System.out.println(ro.orangesRotting(grid));
    }
}

/*

Thinking:

1. [[0]] -> 0
2. [[1]] -> -1



-ref: https://leetcode.com/problems/rotting-oranges/submissions/1451694193/

 */