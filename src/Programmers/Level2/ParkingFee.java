package Programmers.Level2;

import java.util.*;

public class ParkingFee {
    public int calculator(int time, int baseTime, int baseRate, int unitTime, int unitRate){
        int rate = baseRate;
        time -= baseTime;
        if(time <= 0) return baseRate;
        rate += (time/unitTime*unitRate);
        if(time%unitTime>0) rate += unitRate;
        return rate;
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> parking = new HashMap<>();
        HashMap<String, Integer> in = new HashMap<>();
        for(String s : records){
            String[] infos = s.split(" ");
            String[] time = infos[0].split(":");
            int curTime = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            if(infos[2].equals("IN")){
                in.put(infos[1], curTime);
            }
            else if(infos[2].equals("OUT")){
                parking.put(infos[1], parking.getOrDefault(infos[1], 0)+(curTime-in.get(infos[1])));
                in.remove(infos[1]);
            }
        }
        for(Map.Entry<String, Integer> entry : in.entrySet()){
            int time = 23*60+59-entry.getValue();
            parking.put(entry.getKey(), parking.getOrDefault(entry.getKey(), 0)+time);
        }
        List<String> keySet = new ArrayList<>(parking.keySet());
        keySet.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
        int[] answer = new int[parking.size()];
        for(int i=0; i<keySet.size(); i++){
            answer[i] = calculator(parking.get(keySet.get(i)), fees[0], fees[1], fees[2], fees[3]);
        }
        return answer;
    }

    public static void main(String[] args){
        ParkingFee pf = new ParkingFee();
        int[] fees = {180, 5000, 10, 600};//basic time, fee, 10분마다 600원
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        for(int i : pf.solution(fees, records)){
            System.out.print(i + " ");
        }
    }
}
/*
feedback:

##, TreeMap 자료형을 사용하면 key값 기준으로 자동 오름차순 정렬을 한다.

List<String> keySet = new ArrayList<>(parking.keySet());
keySet.sort(new Comparator<String>(){
    @Override
    public int compare(String o1, String o2){
        return o1.compareTo(o2);
    }
});
int[] answer = new int[parking.size()];
for(int i=0; i<keySet.size(); i++){
    answer[i] = calculator(parking.get(keySet.get(i)), fees[0], fees[1], fees[2], fees[3]);
}

위의 소스를 생략할 수 있음(알아서 해준다).
 */
