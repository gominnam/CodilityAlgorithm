package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(picture[y][x] != 0) {
                    int size = calculator(new Node(x, y), picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int calculator(Node n, int[][] picture){
        int size = 1;
        int curAreaValue = picture[n.y][n.x];
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        picture[n.y][n.x] = 0;
        while(!q.isEmpty()){
            Node curPos = q.poll();
            for(int j=0; j<4; j++){
                int nx = curPos.x + move[j][0];
                int ny = curPos.y + move[j][1];
                if(0 <= nx && nx < picture[0].length && 0 <= ny && ny < picture.length && picture[ny][nx] == curAreaValue && picture[ny][nx] != 0){
                    picture[ny][nx] = 0;
                    q.offer(new Node(nx, ny));
                    size++;
                }
            }
        }
        return size;
    }

    public static void main(String[] args){
        ColoringBook cb = new ColoringBook();
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        for(int i : cb.solution(6, 4, picture)){
            System.out.print(i + " ");
        }
    }
}
/*
programmer에서 picture 값을 직접 변경시에 에러가 나는 문제가 생김
2차원 배열을 복사하여 풀면 위의 풀이가 정답.
 */