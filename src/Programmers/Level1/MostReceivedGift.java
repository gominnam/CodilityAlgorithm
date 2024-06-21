package Programmers.Level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MostReceivedGift {

    public static void main(String[] args){
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(String friend : friends){
            map.put(friend, new HashMap<>());
        }
        for(String gift : gifts){
            String[] split = gift.split(" ");
            String giver = split[0];
            String receiver = split[1];
            map.get(receiver).put(giver, map.get(receiver).getOrDefault(giver, 0) + 1);
            map.get(receiver).put(receiver, map.get(receiver).getOrDefault(receiver, 0) - 1);
            map.get(giver).put(giver, map.get(giver).getOrDefault(giver, 0) + 1);
        }

        int answer = 0;
        for(String giver : friends){
            int received = 0;
            int giftIndex = map.get(giver).getOrDefault(giver, 0);
            for(String receiver : friends){
                if(giver.equals(receiver)) continue;
                if(map.get(receiver).getOrDefault(giver, 0) > map.get(giver).getOrDefault(receiver, 0))
                    received++;
                if(Objects.equals(map.get(receiver).getOrDefault(giver, 0), map.get(giver).getOrDefault(receiver, 0)))
                    if(giftIndex > map.get(receiver).getOrDefault(receiver, 0)) received++;
            }
            answer = Math.max(answer, received);
        }
        System.out.println(answer);
    }
}

/*
- ref: https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java

# 1.
friend: ["muzi", "ryan", "frodo", "neo"]
gifts: ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
answer = 2

# 2.
friend: ["joy", "brad", "alessandro", "conan", "david"]
gifts: ["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]
answer = 4

 */