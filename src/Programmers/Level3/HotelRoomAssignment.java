package Programmers.Level3;

import java.util.TreeMap;

public class HotelRoomAssignment {
    private TreeMap<Long, Long> roomMap = new TreeMap<>();

    private long findAvailableRoom(long room) {
        if (!roomMap.containsKey(room)) {
            roomMap.put(room, room + 1);
            return room;
        }

        long nextAvailable = findAvailableRoom(roomMap.get(room));
        roomMap.put(room, nextAvailable + 1);
        return nextAvailable;
    }

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            long requestedRoom = room_number[i];
            long assignedRoom = findAvailableRoom(requestedRoom);
            answer[i] = assignedRoom;
        }

        return answer;
    }

    public static void main(String[] args){
        HotelRoomAssignment hotelRoomAssignment = new HotelRoomAssignment();
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] result = hotelRoomAssignment.solution(k, room_number);
        for (long room : result) {
            System.out.println(room);
        }
    }

}

/*

Thinking:
1) HashSet으로 문제를 해결한 결과 최악의 경우인 경우 시간초과 발생 (시간복잡도 O(n^2))

2) TreeMap을 사용하여 문제 해결 (시간복잡도 O(nlogn))

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/64063

 */