package Inflearn.Dynamic;

import java.util.Scanner;

public class StairClimbTopDown {
    static int[] floorWays;

    public int solve(int floor){
        if(floor < 3) return floorWays[floor];
        if(floorWays[floor] != 0) return floorWays[floor];
        return floorWays[floor] = solve(floor-1) + solve(floor-2);
    }

    public static void main(String[] args){
        StairClimbTopDown T = new StairClimbTopDown();
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        floorWays = new int[floor+1];
        floorWays[1] = 1;
        floorWays[2] = 2;
        System.out.print(T.solve(floor));
    }
}
/*Dynamic Programming
feedback - 재귀호출로 푸는 방법(Top Down)
>> 장점: 소스로 인한 가독성이 좋지만 자원사용과 효율성이 Bottom Up 보다 떨어진다.

계단오르기

설명

철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는

1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.

그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?

Image1.jpg


입력
첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.


출력
첫 번째 줄에 올라가는 방법의 수를 출력합니다.

TEST CASE:
7

==> 21
 */