package concurrency;

import java.util.concurrent.*;

public class TestCallable {
    public void loopCallable(final int sleepTime) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> callableTask = () -> {
            Thread.sleep(sleepTime);
            return "In " + Thread.currentThread().getName();
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 5; i++) {
                Future<String> future = executorService.submit(callableTask);
                System.out.println("get: " + future.get(350, TimeUnit.MILLISECONDS));
            }
        } finally {
            executorService.shutdown();
        }
    }

    public void loopCallableThrowsException(final int sleepTime) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> callableTask = () -> {
            throw new IllegalStateException("I throw this exception in : " + Thread.currentThread().getName());
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 5; i++) {
                Future<String> future = executorService.submit(callableTask);
                System.out.println("get: " + future.get(350, TimeUnit.MILLISECONDS));
            }
        } catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        finally {
            executorService.shutdown();
        }
    }
}
