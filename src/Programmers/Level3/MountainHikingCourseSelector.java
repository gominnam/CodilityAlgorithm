package Programmers.Level3;

import java.util.*;
import java.util.stream.Collectors;

public class MountainHikingCourseSelector {
    static class Node implements Comparable<Node> {
        int end;
        int intensity;

        public Node(int end, int intensity) {
            this.end = end;
            this.intensity = intensity;
        }

        // intensity가 작은 것부터 우선순위 큐에 들어가도록
        @Override
        public int compareTo(Node o) {
            int intensityComparison = Integer.compare(this.intensity, o.intensity);
            if (intensityComparison == 0) {
                return Integer.compare(this.end, o.end); // intensity가 같을 경우 end 값이 작은 것이 우선순위가 높게
            } else {
                return intensityComparison;
            }
        }
    }

    public static ArrayList<Node>[] createGraph(int n, int[][] paths, Set<Integer> summitSet, Set<Integer> gateSet) {
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] path : paths){
            if(summitSet.contains(path[0]) || gateSet.contains(path[1])){
                graph[path[1]].add(new Node(path[0], path[2]));
            }
            else if(summitSet.contains(path[1]) || gateSet.contains(path[0])){
                graph[path[0]].add(new Node(path[1], path[2]));
            }
            else{
                graph[path[0]].add(new Node(path[1], path[2]));
                graph[path[1]].add(new Node(path[0], path[2]));
            }
        }

        return graph;
    }

    public static int[] calculateMinimumIntensity(ArrayList<Node>[] graph, int[] gates, Set<Integer> summitSet) {
        int[] answer = {0, Integer.MAX_VALUE};
        boolean[] visited = new boolean[graph.length];
        int[] intensity = new int[graph.length];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int gate : gates){
            intensity[gate] = 0;
            pq.add(new Node(gate, 0));
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int current = node.end;

            if(visited[current]) continue;
            visited[current] = true;

            int currentIntensity = node.intensity;

            if(summitSet.contains(current)){
                if(currentIntensity < answer[1] || (currentIntensity == answer[1] && current < answer[0])){
                    answer[0] = current;
                    answer[1] = currentIntensity;
                }
                continue;
            }

            if(currentIntensity > intensity[current]) continue;

            for(Node nextNode : graph[current]){
                int next = nextNode.end;
                int nextIntensity = Math.max(currentIntensity, nextNode.intensity);

                if(nextIntensity < intensity[next]){
                    intensity[next] = nextIntensity;
                    pq.add(new Node(next, nextIntensity));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int n = 7;
        int[][] paths = {{1, 6, 1}, {1, 4, 1}, {6, 7, 1}, {6, 2, 7}, {4, 5, 1}, {5, 2, 1}, {2, 3, 1}};
        int[] gates = {3, 7};
        int[] summits = {1, 5};

        Set<Integer> summitSet = Arrays.stream(summits).boxed().collect(Collectors.toSet());
        Set<Integer> gateSet = Arrays.stream(gates).boxed().collect(Collectors.toSet());
        ArrayList<Node>[] graph = createGraph(n, paths, summitSet, gateSet);
        int[] answer = calculateMinimumIntensity(graph, gates, summitSet);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

/*
-ref: https://school.programmers.co.kr/learn/courses/30/lessons/118669?language=java
TEST CASE:
1)
n = 6
paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}
gates = {1, 3}
summits = {5}

answer = {5, 3}

2)
n = 7
paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}
gates = {3, 7}
summits = {1, 5}

answer = {5, 1}

3)
n = 7
paths = {{1, 6, 1}, {1, 4, 1}, {6, 7, 1}, {6, 2, 7}, {4, 5, 1}, {5, 2, 1}, {2, 3, 1}}
gates = {3, 7}
summits = {1, 5}

answer = {1, 1}

refactoring point:
1. Set<Integer> summitSet = Arrays.stream(summits).boxed().collect(Collectors.toSet());
    - Arrays.stream(summits)는 summits 배열을 스트림으로 변환합니다. 스트림은 데이터의 연속적인 흐름을 나타내며, 이를 통해 데이터를 더 효율적으로 처리할 수 있습니다.
    - boxed()는 기본 데이터 타입의 스트림을 객체 스트림으로 변환합니다. 이 경우, int 타입의 스트림을 Integer 객체 스트림으로 변환합니다.
    - collect(Collectors.toSet())는 스트림의 모든 요소를 수집하여 Set으로 반환합니다. 이 경우, Integer 객체의 스트림을 Set<Integer>로 변환합니다.




thinkings:
플로이드-와샬로 풀려고 했지만 O(n^3)의 시간복잡도를 갖기 때문에
주어진 n의 값은 최대 50000까지 가능하기 때문에 50000^3은 너무 큰 값으로 시간초과 그래서 그리디로 변경
//    public static boolean isSummit(int[] summits, int idx){
//        for(int summit : summits){
//            if(summit == idx) return true;
//        }
//        return false;
//    }
//
//    public static boolean isGate(int[] gates, int idx){
//        for(int gate : gates){
//            if(gate == idx) return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args){
//        int n = 6;
//        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//        int[] gates = {1, 3};
//        int[] summits = {5};
//
//        int[][] graph = new int[n+1][n+1];
//        for(int[] path : paths){
//            graph[path[0]][path[1]] = path[2];
//            graph[path[1]][path[0]] = path[2];
//        }
//
//        int[] answer = {0, Integer.MAX_VALUE};
//        for(int i=1; i<=n; i++){//중간 연결
//            if(isSummit(summits, i)) continue;
//            for(int j=1; j<=n; j++){//시작
//                for(int k=1; k<=n; k++){//도착
//                    if(graph[j][i] != 0 && graph[i][k] != 0){
//                        if(graph[j][k] == 0) graph[j][k] = Math.max(graph[j][i], graph[i][k]);
//                        else graph[j][k] = Math.min(graph[j][k], Math.max(graph[j][i],  graph[i][k]));
//
//                        if(isGate(gates, j) && isSummit(summits, k)){
//                            if(answer[1] > graph[j][k] || (answer[0] < k && answer[1] == graph[j][k])){
//                                answer[0] = k;
//                                answer[1] = graph[j][k];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(answer[0] + " " + answer[1]);
//    }


 */