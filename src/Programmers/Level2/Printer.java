package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    class Page{
        int priority;
        int index;
        public Page(int p, int i){
            this.priority = p;
            this.index = i;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Page> pages = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            pages.add(new Page(priorities[i], i));
        }
        Integer[] pt = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(pt, Collections.reverseOrder());
        int pointer = 0;
        while(!pages.isEmpty()){
            Page p = pages.poll();
            if(p.priority == pt[pointer]){
                pointer++;
                if(p.index == location) return pointer;
            }
            else pages.add(p);
        }
        return 0;
    }

    public static void main(String[] args){
        Printer p = new Printer();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.print(p.solution(priorities, location));
    }
}
