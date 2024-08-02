package Programmers.Level3;

import java.util.*;

public class CodingStudy {

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        // 최대 필요한 알고력과 코딩력을 구함
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        // 현재의 알고력과 코딩력이 최대값을 넘지 않도록
        // dp 인덱스가 벗어날 수 있기 때문에
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        // DP 테이블 초기화 (알고력, 코딩력 조합별 최소 시간 저장)
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        // DP를 통해 최소 시간 계산
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 알고력 1 증가
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }

                // 코딩력 1 증가
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

                // 문제 풀기
                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if (i >= alpReq && j >= copReq) {
                        int newAlp = Math.min(maxAlp, i + alpRwd);
                        int newCop = Math.min(maxCop, j + copRwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }

    public int solution2(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        // 최대 필요한 알고력과 코딩력을 구함
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        // 현재의 알고력과 코딩력이 최대값을 넘지 않도록
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        // BFS를 위한 큐와 방문 체크용 셋
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{alp, cop, 0});
        visited.add(alp + "," + cop);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curAlp = current[0];
            int curCop = current[1];
            int curTime = current[2];

            // 목표 도달 시 시간 반환
            if (curAlp >= maxAlp && curCop >= maxCop) {
                return curTime;
            }

            // 알고력 1 증가
            if (curAlp + 1 <= maxAlp && !visited.contains((curAlp + 1) + "," + curCop)) {
                queue.add(new int[]{curAlp + 1, curCop, curTime + 1});
                visited.add((curAlp + 1) + "," + curCop);
            }

            // 코딩력 1 증가
            if (curCop + 1 <= maxCop && !visited.contains(curAlp + "," + (curCop + 1))) {
                queue.add(new int[]{curAlp, curCop + 1, curTime + 1});
                visited.add(curAlp + "," + (curCop + 1));
            }

            // 문제 풀기
            for (int[] problem : problems) {
                int alpReq = problem[0];
                int copReq = problem[1];
                int alpRwd = problem[2];
                int copRwd = problem[3];
                int cost = problem[4];

                if (curAlp >= alpReq && curCop >= copReq) {
                    int newAlp = Math.min(maxAlp, curAlp + alpRwd);
                    int newCop = Math.min(maxCop, curCop + copRwd);
                    if (!visited.contains(newAlp + "," + newCop)) {
                        queue.add(new int[]{newAlp, newCop, curTime + cost});
                        visited.add(newAlp + "," + newCop);
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }

    public static void main(String[] args) {
        CodingStudy sol = new CodingStudy();
        int alp = 0;
        int cop = 0;
        int[][] problems = {
                {0,0,2,1,2},
                {4,5,3,1,2},
                {4,11,4,0,2},
                {10,4,0,4,2}
        };
        System.out.println(sol.solution(alp, cop, problems));  // 예상 결과 출력
        System.out.println(sol.solution2(alp, cop, problems));  // 예상 결과 출력
    }
}

/*
Thinking:
1)
Dynamic Programming

2)
BFS (PriorityQueue)
- lambda를 이용한 Comparator 사용
    - PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    - 내림차순일 경우: PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/118668

 */