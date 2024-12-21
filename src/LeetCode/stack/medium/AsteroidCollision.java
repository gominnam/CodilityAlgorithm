package LeetCode.stack.medium;

import java.util.*;

public class AsteroidCollision {

    Stack<Integer> rightAsteroid = new Stack<>();
    List<Integer> result = new ArrayList<>();

    public int[] asteroidCollision(int[] asteroids) {

        for(int i : asteroids){
            if(i>0) rightAsteroid.add(i);
            else if(i<0) handleCollision(i);//call method
        }

        if(!rightAsteroid.isEmpty()){
            List<Integer> t = rightAsteroid.subList(0, rightAsteroid.size());
            result.addAll(t);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public void handleCollision(int negative){
        if(!rightAsteroid.isEmpty()){
            int right = rightAsteroid.pop();
            if(right > Math.abs(negative)){
                rightAsteroid.add(right);
            }
            else if(right < Math.abs(negative)){
                handleCollision(negative);
            }
        }
        else {
            result.add(negative);
        }
    }

    public int[] asteroidCollision_gpt(int[] asteroids) { // gpt 개선된 코드
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        int[] asteroids = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10, 2, -5};
        int[] asteroids4 = {-2, -1, 1, 2};
        int[] asteroids5 = {1, -1, -1, -1};
        int[] asteroids6 = {1, 2, 3, 4, -1, -2, -3, -4};
        /*System.out.println(Arrays.toString(ac.asteroidCollision(asteroids))); // [5, 10]
        result.clear();
        rightAsteroid.clear();
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids2))); // []
        result.clear();
        rightAsteroid.clear();
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids3))); // [10]
        result.clear();
        rightAsteroid.clear();
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids4))); // [-2, -1, 1, 2]
        result.clear();
        rightAsteroid.clear();
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids5))); // [-1, -1, -1]
        result.clear();
        rightAsteroid.clear();*/
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids6))); // [-1, -2, -3, -4]
    }
}

/*

Thinking:
- 양수는 오른쪽으로 이동하고, 음수는 왼쪽으로 이동한다.
- Stack 을 사용하여 음수가 들어왔을 때 처리하는 방식으로 구현.

-ref: https://leetcode.com/problems/asteroid-collision

 */