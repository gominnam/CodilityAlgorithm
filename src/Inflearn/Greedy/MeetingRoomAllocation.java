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
        public int compareTo(Room r){
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
