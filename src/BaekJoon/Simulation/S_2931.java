package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum PipeType {
    CROSS('+', new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}),
    VERTICAL('|', new int[][]{{1, 0}, {-1, 0}}),
    HORIZONTAL('-', new int[][]{{0, 1}, {0, -1}}),
    RIGHT_BOTTOM('1', new int[][]{{1, 0}, {0, 1}}),
    RIGHT_TOP('2', new int[][]{{-1, 0}, {0, 1}}),
    LEFT_TOP('3', new int[][]{{-1, 0}, {0, -1}}),
    LEFT_BOTTOM('4', new int[][]{{1, 0}, {0, -1}});

    private final char representation;
    private final int[][] directions;

    PipeType(char representation, int[][] directions) {
        this.representation = representation;;
        this.directions = directions;
    }

    public char getRepresentation() {
        return representation;
    }

    public int[][] getDirections() {
        return directions;
    }

    public static PipeType fromChar(char c) {
        for (PipeType p : PipeType.values()) {
            if (p.getRepresentation() == c) {
                return p;
            }
        }
        throw new IllegalArgumentException("Unkown PipeType: " + c);
    }
}

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class S_2931 {
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static List<Node> mapping(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        List<Node> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Node n = queue.poll();
            int x = n.x;
            int y = n.y;
            for(PipeType p : PipeType.values()){
                if(map[x][y] == p.getRepresentation()){
                    for(int[] d : p.getDirections()){
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
                        if(map[nx][ny] != '.'){
                            visited[nx][ny] = true;
                            queue.offer(new Node(nx, ny));
                        }
                        else {
                            result.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);//행
        C = Integer.parseInt(input[1]);//열
        map = new char[R][C];
        visited = new boolean[R][C];
        //지워진 블록의 행과 열 위치를 출력하고, 어떤 블록이었는지를 출력한다.
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'M' || map[i][j] == 'Z'){
                    nodes.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        // 정답 구할때 x, y 더하기 1씩 하기
        List<Node> missingNode = new ArrayList<>();
        for(int i=0; i<2; i++){
            for(int j=0; j<4; j++){
                int nx = nodes.get(i).x + dir[j][0];
                int ny = nodes.get(i).y + dir[j][1];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] != '.'){
                    visited[nx][ny] = true;
                    missingNode.addAll(mapping(new Node(nx, ny)));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] pos = { missingNode.get(0).x, missingNode.get(0).y };
        sb.append(pos[0]+1).append(" ").append(pos[1]+1).append(" ");

        for(PipeType p : PipeType.values()){
            boolean isValid = true;
            for(int[] d : p.getDirections()){
                int nx = pos[0] + d[0];
                int ny = pos[1] + d[1];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'M' || map[nx][ny] == 'Z') {
                    isValid = false;
                    break;
                }
                if(map[nx][ny] == '.') {
                    isValid = false;
                    break;
                }
                PipeType check = PipeType.fromChar(map[nx][ny]);
                boolean isConnected = false;
                for(int[] cd : check.getDirections()){
                    int mx = nx+cd[0];
                    int my = ny+cd[1];
                    if(mx == pos[0] && my == pos[1]){
                        isConnected = true;
                        continue;
                    }
                    if(mx < 0 || my < 0 || mx >= R || my >= C || map[mx][my] == '.' ) {
                        isConnected = false;
                        break;
                    }
                }
                if(!isConnected){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                sb.append(p.getRepresentation());
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

TEST CASE:
1)
6 10
Z.1----4..
|.|....|..
|..14..M..
2-+++4....
..2323....
..........

==> 3 3 |

2)
3 5
..1-M
1-.4.
Z.23.

==> 2 3 +

3)
3 7
.14....
.M.Z...
..23...

==> 2 3 |

4)
3 7
..1-4..
M-+-.-4
..2-3.Z

==> 2 5 +

3 2
MZ
||
.3

 */