package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TripRoute {
    public static boolean[] visited;
    public static boolean flag = false;
    public static ArrayList<String> answer = new ArrayList<>();
    public static String[] result;

    public void DFS(int L, String[][] tickets, String from){
        if(flag) return;
        if(L==tickets.length){
            answer.add(from);
            result = answer.toArray(result);
            flag = true;
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(from) && !visited[i]){
                visited[i] = true;
                answer.add(from);
                DFS(L+1, tickets, tickets[i][1]);
                answer.remove(answer.size()-1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        result = new String[n+1];
        visited = new boolean[n];
        Arrays.sort(tickets, Comparator.comparing((String[] row) -> row[1]));
        answer.add("ICN");
        for(int i=0; i<n; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                DFS(1, tickets, tickets[i][1]);
                visited[i] = false;
            }
            if(flag) break;
        }
        return result;
    }

    public static void main(String[] args){
        TripRoute tr = new TripRoute();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        for(String str : tr.solution(tickets)){
            System.out.print(str + " ");
        }
    }
}
/*

[ TIP ]

다른 접근 방법 해결 방안
다른 풀이 소스를 보니 Stack을 사용하여 해결
생각해볼 것
Arrays.sort(tickets, Comparator.comparing((String[] row) -> row[1]));
Arrays.sort(tickets, Comparator.comparing((String[] row) -> row[1]));//reversed();

 */