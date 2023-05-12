package Programmers.Level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for(String str : operations){
            String[] s = str.split(" ");

            if(s[0].equals("I")){
                pq1.offer(Integer.parseInt(s[1]));
                pq2.offer(Integer.parseInt(s[1]));
            }

            if(s[0].equals("D")){
                if(!pq1.isEmpty() && s[1].equals("-1")){
                    int tmp = pq1.poll();
                    pq2.remove(tmp);
                }
                else if(!pq2.isEmpty() && s[1].equals("1")){
                    int tmp = pq2.poll();
                    pq1.remove(tmp);
                }
            }
        }

        if(!pq1.isEmpty()){
            answer[0] = pq2.peek();
            answer[1] = pq1.peek();
        }

        return answer;
    }

    public static void main(String[] args){
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        for(int i : dpq.solution(operations2)){
            System.out.print(i + " ");
        }
    }
}
