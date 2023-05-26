package Programmers.Level3;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        int curCameraIdx = -30001;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] <= curCameraIdx) continue;
            answer++;
            curCameraIdx = routes[i][1];
        }
        return answer;
    }

    public static void main(String[] args){
        EnforcementCamera ec = new EnforcementCamera();
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(ec.solution(routes));
    }
}

/*
feed back:
Greedy Algorithm(탐욕법)

Arrays.sort();
의 함수를 int[][]에서 사용하는 방법 위의 소스 참고
Comparator.comparingInt(a -> a[0])에서
a[x]의 x값으로 int[y][x] 몇번째 기준으로 정렬할지 정할 수 있다.

 */