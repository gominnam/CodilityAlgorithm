package Programmers.Level3;

public class InsertAdvertisement {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        int playTimeSecond = timeToSecond(play_time);
        int advTimeSecond = timeToSecond(adv_time);
        int[] totalPlayTime = new int[playTimeSecond + 1];

        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSecond(times[0]);
            int end = timeToSecond(times[1]);
            for (int i = start; i < end; i++) {
                totalPlayTime[i]++;
            }
        }

        long maxPlayTime = 0;
        for (int i = 0; i < advTimeSecond; i++) {
            maxPlayTime += totalPlayTime[i];
        }

        long currentPlayTime = maxPlayTime;
        int startTime = 0;
        for (int i = advTimeSecond; i < playTimeSecond; i++) {
            currentPlayTime = currentPlayTime + totalPlayTime[i] - totalPlayTime[i - advTimeSecond];
            if (currentPlayTime > maxPlayTime) {
                maxPlayTime = currentPlayTime;
                startTime = i - advTimeSecond + 1;
            }
        }

        System.out.println(secondToTime(startTime));
    }

    public static int timeToSecond(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 3600 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);
    }

    public static String secondToTime(int second){
        int hour = second/3600;
        second %= 3600;
        int minute =  second / 60;
        second %= 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

/*

Thinking:
1)
WindowSliding 문제
- 광고의 시작 시간을 0부터 play_time까지 이동시키면서 광고 시간만큼의 구간을 계산한다.

)
String.format("%02d:%02d:%02d", hour, minute, second);
- %02d: 2자리 정수로 표현하되, 한 자리 수일 경우 0으로 채워준다.

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/72414

 */