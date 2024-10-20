package cs.deadlock;

public class PhilosopherDining {

    public static void main(String[] args){
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];

        for(int i = 0; i < numPhilosophers; i++){
            chopsticks[i] = new Chopstick();
        }

        for(int i = 0; i < numPhilosophers; i++){
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % numPhilosophers];

            // 교착상태 방지: 마지막 철학자는 젓가락을 반대로 집음
            if (i == numPhilosophers - 1) {
                philosophers[i] = new Philosopher(right, left);
            } else {
                philosophers[i] = new Philosopher(left, right);
            }

            philosophers[i].setName("Philosopher " + (i + 1));
            philosophers[i].start();
        }
    }
}
