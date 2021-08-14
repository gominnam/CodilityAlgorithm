package Inflearn.Greedy;

import java.util.*;

public class MeetingRoomAllocation {




    public static void main(String[] args){
        MeetingRoomAllocation T = new MeetingRoomAllocation();
        Scanner sc = new Scanner(System.in);
        ArrayList<Wresler.People> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Wresler.People(a, b));
        }

        Collections.sort(arr);
        int maxW = Integer.MIN_VALUE;
        maxW = arr.get(0).weight;
        int answer = 0;
        for(Wresler.People p : arr){
            if(p.weight >= maxW) {
                maxW = p.weight;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
