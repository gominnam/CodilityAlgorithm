package cs.deadlock;

import java.util.Random;

public class Philosopher extends Thread {
    private final Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if(pickUp()) {
            chew();
            putDown();
        }
    }

    public boolean pickUp() {
        if(!left.pickUp()) {
            return false;
        }
        if(!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public void chew() {
        System.out.println(Thread.currentThread().getName() + " is eating");
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() {
        System.out.println(Thread.currentThread().getName() + " is thinking");
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                if(pickUp()){
                    chew();
                    putDown();
                    think();
                }
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
