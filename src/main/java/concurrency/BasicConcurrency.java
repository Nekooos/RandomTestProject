package concurrency;

import java.util.concurrent.*;

public class BasicConcurrency {


    public Integer addNumbers(int x, int y) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> callableObj = () -> x+y;
        ExecutorService service =  Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        return future.get();
    }

    public Future<Integer> addNumbersDelay(int x, int y) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> callableObj = () -> {
            Thread.sleep(1000);
            return x+y;
        };
        ExecutorService service =  Executors.newSingleThreadExecutor();
        return service.submit(callableObj);
    }
}
