package LeetCode.HashTable.medium;

import java.util.*;

public class FindingtheUsersActiveMinutes {

    static class User {
        Set<Integer> active;

        public User(){
            active = new HashSet<>();
        }
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];
        Map<Integer, User> userMap = new HashMap<>();
        for(int[] log : logs){
            int user = log[0];
            int active = log[1];
            userMap.putIfAbsent(user, new User());
            userMap.get(user).active.add(active);
        }
        for(User u : userMap.values()){
            answer[u.active.size()-1]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        FindingtheUsersActiveMinutes o = new FindingtheUsersActiveMinutes();
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        int[] result = o.findingUsersActiveMinutes(logs, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

/*

Thinking:
- User 객체 내부에 Set 자료구조를 사용하여 HashMap으로 Active Time count 값을 구한 후 정답 반환

-ref: https://leetcode.com/problems/finding-the-users-active-minutes/

 */