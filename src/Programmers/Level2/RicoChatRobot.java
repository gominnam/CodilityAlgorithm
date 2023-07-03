package Programmers.Level2;

import java.util.Stack;

public class RicoChatRobot {
    static int[] mX = {0, 0, 1, -1};
    static int[] mY = {1, -1, 0, 0 };
    static boolean flag = false;
    static int answer = 0;

    public class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[] board) {
        Node node = new Node(0, 0);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if (board[i].charAt(j) == 'R') {
                    node.x = i;
                    node.y = j;
                    board[i] = board[i].substring(0, j) + '.' + board[i].substring(j+1);
                    break;
                }
            }
        }
        bfs(node, board);
        if(!flag) answer = -1;
        return answer;
    }

    public void bfs(Node node, String[] board){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            if(flag) return;
            answer++;
            Node n = stack.pop();
            for(int i=0; i<4; i++){
                int nX = n.x + mX[i];
                int nY = n.y + mY[i];
                int test = 0;
                while(0 <= nX && nX < board.length && 0 <= nY && nY < board[0].length()){
                    test++;
                    if(board[nX].charAt(nY) == '.'){
                        nX += mX[i];
                        nY += mY[i];
                    }
                    else if(board[nX].charAt(nY) == '0') break;
                    else if(board[nX].charAt(nY) == 'D' && test == 1){
                        if(board[nX-mX[i]].charAt(nY-mY[i]) == 'G'){
                            flag = true;
                            break;
                        }
                        stack.push(new Node(nX-mX[i], nY-mY[i]));
                        board[nX-mX[i]] = board[nX-mX[i]].substring(0, nY-mY[i]) + '0' + board[nX-mX[i]].substring(nY-mY[i]+1);
                        break;
                    }
                    else if((nX == 0 && nY == 0) || (nX == 0 && nY == board[0].length()-1) || (nX == board.length-1 && nY == 0) || (nX == board.length-1 && nY == board[0].length()-1)){
                        stack.push(new Node(nX, nY));
                        board[nX] = board[nX].substring(0, nY) + '0' + board[nX].substring(nY+1);
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        RicoChatRobot rcr = new RicoChatRobot();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        rcr.solution(board);
        System.out.print("answer : " + answer);
    }
}
