package cs.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private final Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    /* 젓가락 집기 */
    public boolean pickUp() {
        return lock.tryLock();
    }

    /* 젓가락 내려놓기 */
    public void putDown() {
        lock.unlock();
    }
}

/*

Lock 인터페이스는 synchronized 키워드와 같은 기능을 제공하지만, 더 많은 기능을 제공한다.

- tryLock() 메소드는 다른 스레드가 이미 lock을 획득한 경우에 대기하지 않고 false를 반환한다.
- unlock() 메소드는 반드시 lock을 획득한 스레드에서 호출해야 한다.

 */