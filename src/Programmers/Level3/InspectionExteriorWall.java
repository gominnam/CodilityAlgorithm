package Programmers.Level3;

import java.util.*;

public class InspectionExteriorWall {
    public int solution(int n, int[] weak, int[] dist) {
        // 취약 지점을 두 배로 늘리기
        int length = weak.length;
        int[] extendedWeak = new int[length * 2];
        for (int i = 0; i < length; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + length] = weak[i] + n;
        }

        int answer = dist.length + 1;  // 최대 친구 수 + 1로 초기화

        // 가능한 모든 친구 배치 순서에 대해 탐색
        List<Integer> friendsList = new ArrayList<>();
        for (int d : dist) {
            friendsList.add(d);
        }
        Collections.sort(friendsList, Collections.reverseOrder());

        // 가능한 모든 친구 배치 순서에 대해 탐색
        for (int start = 0; start < length; start++) {
            List<int[]> permutations = getPermutations(friendsList, friendsList.size());
            for (int[] friends : permutations) {
                int count = 1;  // 사용한 친구 수
                int position = extendedWeak[start] + friends[count - 1];  // 첫 번째 친구가 점검할 수 있는 마지막 위치

                for (int index = start; index < start + length; index++) {
                    if (position < extendedWeak[index]) {  // 점검할 수 있는 위치를 벗어난 경우
                        count += 1;  // 새로운 친구 투입
                        if (count > dist.length) {  // 친구를 모두 사용한 경우
                            break;
                        }
                        position = extendedWeak[index] + friends[count - 1];
                    }
                }

                answer = Math.min(answer, count);  // 최소 친구 수 갱신
            }
        }

        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }

    // 리스트에서 모든 순열을 생성하는 메서드
    private List<int[]> getPermutations(List<Integer> list, int size) {
        List<int[]> result = new ArrayList<>();
        permute(list, 0, size, result);
        return result;
    }

    private void permute(List<Integer> list, int start, int size, List<int[]> result) {
        if (start == size) {
            int[] permutation = new int[size];
            for (int i = 0; i < size; i++) {
                permutation[i] = list.get(i);
            }
            result.add(permutation);
        } else {
            for (int i = start; i < list.size(); i++) {
                Collections.swap(list, i, start); // 변경
                permute(list, start + 1, size, result); // 순환 매서드 재귀 호출
                Collections.swap(list, i, start); // 원래대로 복구
            }
        }
    }

    public static void main(String[] args){
        InspectionExteriorWall inspectionExteriorWall = new InspectionExteriorWall();
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        System.out.print(inspectionExteriorWall.solution(n, weak, dist));
        //12	[1, 5, 6, 10]	[1, 2, 3, 4]
        //return: 2
    }
}

/*

Thinking:
1)
Permutation(순열):

2)
Collection.swap(list, index1, index2):
- list의 index1과 index2의 값을 서로 바꾼다.
- index는 0부터 시작한다.


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/60062

*/
