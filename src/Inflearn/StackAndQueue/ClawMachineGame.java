package Inflearn.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class ClawMachineGame {
    public int Solve(int n, int[][] a1, int m, int[] a2){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<m; i++){
            int lane = a2[i]-1;
            for(int j=0; j<n; j++){
                if(a1[j][lane] == 0) continue;
                else if(!stack.isEmpty() && stack.peek() == a1[j][lane]) {
                    stack.pop();
                    answer += 2;
                }
                else stack.push(a1[j][lane]);

                a1[j][lane] = 0;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        ClawMachineGame T = new ClawMachineGame();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a1 = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a1[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] a2 = new int[m];
        for(int i=0; i<m; i++){
            a2[i] = sc.nextInt();
        }

        System.out.println(T.Solve(n, a1, m, a2));
    }
}

/*
카카오 인형뽑기 문제

TEST CASE:
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4

==> 4
 */