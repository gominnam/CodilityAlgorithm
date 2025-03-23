package LeetCode.Graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses]; // 차수

        // 1. 강좌 수 만큼 graph 생성
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 다음 강좌를 graph에 추가
        for(int[] p : prerequisites){
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        // 3. 진입차수가 0인 강좌를 큐에 추가 (가장 먼저 시작점)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 4. 위상정렬
        int[] order = new int[numCourses]; // 결과 저장
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[index++] = cur;
            for(int nextCourse : graph.get(cur)){ // 현재 강좌 다음의 강좌 차수 제거 후 차수가 0이면 큐에 추가
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        if(index == numCourses){
            return order;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}}; // [0,1,2,3] or [0,2,1,3]
        for (int i : c.findOrder(numCourses, prerequisites)) {
            System.out.print(i + " ");
        }
    }
}

/*

Thinking:
- graph를 이용한 문제 (위상정렬 (Topological Sort))

- 위상정렬 // 시간복잡도 O(V+E)
1) 진입차수가 0인 정점을 큐에 삽입
2) 큐에서 원소를 꺼내 연결된 모든 간선을 제거
3) 간선 제거 이후 진입차수가 0이 된 정점을 큐에 삽입
4) 큐가 빌 때까지 2~3 반복, 모든 원소를 방문하기 전 큐가 빈다면 사이클이 존재

-ref: https://leetcode.com/problems/course-schedule-ii/

 */