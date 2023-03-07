package Inflearn.Greedy;

import java.util.*;

public class MeetingRoomAllocation {
    static int end = 0, answer = 0;

    public static class Room implements Comparable<Room>{
        int s;//start
        int e;//end
        public Room(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Room r){//오름차순
            if(this.e == r.e) return this.s - r.s;
            else return this.e - r.e;
        }
    }

    public void solution(ArrayList<Room> arr){
        for(Room r : arr){
            if(r.s >= end){
                end = r.e;
                answer++;
            }
        }
    }

    public static void main(String[] args){
        MeetingRoomAllocation T = new MeetingRoomAllocation();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Room> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Room(s, e));
        }
        Collections.sort(arr);
        T.solution(arr);
        System.out.print(answer);
    }
}
/*

회의실 배정
설명

한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.

각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.

단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.


입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데

이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.

회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.


출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

TEST CASE:
5
1 4
2 3
3 5
4 6
5 7

=> 3

 */