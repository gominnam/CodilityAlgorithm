package Programmers.Level3;

public class ConstructionRaceway {
    public int solution(int[][] board) {
        int answer = 0;
        //0, 1
        

        return answer;
    }

    public static void main(String[] args){
        ConstructionRaceway cr = new ConstructionRaceway();
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0}
                        ,{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(cr.solution(board));
    }
}
