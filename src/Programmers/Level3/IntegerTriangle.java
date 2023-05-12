package Programmers.Level3;

public class IntegerTriangle {
    public static int[][] dp;

    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int n = triangle.length;

        for(int i=1; i<n; i++){
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for(int j=1; j<i; j++){
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        for(int i=0; i<n; i++){
            answer = Math.max(answer, triangle[n-1][i]);
        }

        return answer;
    }

    public static void main(String[] args){
        IntegerTriangle it = new IntegerTriangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.print(it.solution(triangle));
    }
}
/*
feed back:

- dynamic programming algorithm


 */