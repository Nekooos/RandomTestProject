package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {
/*    List<Integer> buffer = new ArrayList<>();

    Lock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();
    Condition isFull = lock.newCondition();

    class Consumer implements Callable<String> {
        @Override
        public String call() {
            int count = 0;
            while (count++ < 50) {
                try {
                    lock.lock();
                    while (isEmpty(buffer)) {
                        isEmpty.await();
                    }
                    buffer.remove((buffer.size()-1));

                    //signal
                    isFull.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            return "Consumed" + (count-1);
        }
    }

    class Producer implements Callable<String> {

        @Override
        public String call() throws Exception {
            int count = 0;
            while(count++ < 50) {
                try {
                    lock.lock();

                    while (isFull(buffer)) {
                        // wait
                    }
                    buffer.add(1);
                    //signal
                    isEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
            }
            return "Produced " + (count - 1);
        }
    } */
}
