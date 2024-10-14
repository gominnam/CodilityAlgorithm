package Programmers.Level2;

public class AnalogClock {

    public int getSecond(int h, int m, int s){
        return h * 3600 + m * 60 + s;
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 주어진 시간 (h1, m1, s1)과 (h2, m2, s2)를 초 단위로 변환
        int startTime = getSecond(h1, m1, s1);
        int endTime = getSecond(h2, m2, s2);

        int alarmCount  = 0;
        if(startTime % 360 == 0 || endTime % 360 == 12) alarmCount++;

        // 시침, 분침, 초침의 위치를 0초부터 24시간까지 비교
        for (int t = startTime; t < endTime; t++) {
            double hourHand = (t / 120.0) % 360;
            double minuteHand = (t / 10.0) % 360;
            double secondHand = (t * 6) % 360;

            double hourHandAfterSecond = ((t + 1) / 120.0) % 360;
            double minuteHandAfterSecond = ((t + 1) / 10.0) % 360;
            double secondHandAfterSecond = ((t + 1) * 6) % 360;
            
            if(hourHandAfterSecond == 0) hourHandAfterSecond = 360;
            if(minuteHandAfterSecond == 0) minuteHandAfterSecond = 360;
            if(secondHandAfterSecond == 0) secondHandAfterSecond = 360;

            if(hourHand > secondHand && hourHandAfterSecond <= secondHandAfterSecond) {
                alarmCount++;
            }
            if(minuteHand > secondHand && minuteHandAfterSecond <= secondHandAfterSecond) {
                alarmCount++;
            }
            if(hourHandAfterSecond == minuteHandAfterSecond) alarmCount--;
        }

        return alarmCount;
    }

    public static void main(String[] args){
        AnalogClock analogClock = new AnalogClock();
        int h1 = 0;
        int m1 = 0;
        int s1 = 0;
        int h2 = 23;
        int m2 = 59;
        int s2 = 59;
        System.out.println(analogClock.solution(h1, m1, s1, h2, m2, s2));
    }
}

/*

구현과 계산 문제

TEST CASE:

h1	m1	s1	h2	m2	s2	result
0	5	30	0	7	0	2
12	0	0	12	0	30	1
0	6	1	0	6	6	0
11	59	30	12	0	0	1
11	58	59	11	59	0	1
1	5	5	1	5	6	2
0	0	0	23	59	59	2852

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/250135

 */