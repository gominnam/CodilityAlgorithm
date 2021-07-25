package Programmers.Level2;

import java.util.*;

public class KeepDistance {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length]; // P:응시자, O:빈테이블, X:파티션
        for(int i=0; i<places.length; i++){
            answer[i] = confirm(places[i]);
            /*
            for(String x : places[i]){
                System.out.println(x);
            }
            System.out.println("next");
            */
        }

        return answer;
    }

    public int confirm(String[] p){ // 배열(메모리 순서로 들어옴
        int[][] check = new int[p.length+1][p.length+1];



        //맨해튼 |a - b| + |a2 + b2| > 2
        return 1;
    }

    public static void main(String[] args){
        KeepDistance T = new KeepDistance();
        Scanner sc = new Scanner(System.in);

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        for(int x : T.solution(places)){
            System.out.print(x + " ");
        }
    }
}

/*
거리두기 확인하기
 */
