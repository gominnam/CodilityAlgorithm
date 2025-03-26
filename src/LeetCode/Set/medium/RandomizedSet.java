package LeetCode.Set.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new LinkedHashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        int setSize = set.size();
        int randomIndex = (int)(Math.random() * setSize);
        return (int)set.toArray()[randomIndex];
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2
    }
}

/*

Thinking:
- HashSet을 LinkedListSet으로 구현하여 풀이 진행과 통과를 했지만 요구하는 풀이가 아님

-ref: https://leetcode.com/problems/insert-delete-getrandom-o1

 */