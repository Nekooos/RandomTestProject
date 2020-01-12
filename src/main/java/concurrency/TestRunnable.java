package concurrency;

import java.util.concurrent.*;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Colors.BLUE.getColor() + "Runnable running");
    }
}

class TestRunnable2 {
    Runnable task = () -> System.out.println(Thread.currentThread().getName() + "");

    public void loopRunnable() {
        for(int i=0; i<10; i++) {
            new Thread(task).start();
        }
    }

    public void loopRunnableExecutorsService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0; i<5; i++) {
            executorService.execute(task);
        }

        executorService.shutdown();
    }

    public void loopRunnableFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0; i<5; i++) {
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
