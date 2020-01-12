package concurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

public class BasicConcurrencyTest {
    BasicConcurrency basicConcurrency;

    @BeforeEach
    public void setUp() {
        basicConcurrency = new BasicConcurrency();
    }

    @Test
    public void addNumberTest() throws ExecutionException, InterruptedException, TimeoutException {
        int sum = basicConcurrency.addNumbers(4,6);
        assertEquals(10, sum);
    }

    @Test
    public void addNumbersDelayTest() throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> futureSum = basicConcurrency.addNumbersDelay(4,6);
        while (!futureSum.isDone() && !futureSum.isCancelled()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }
        assertEquals(10, futureSum.get());
    }

    @Test
    public void basicThread() {
        TestThread testThread = new TestThread();
        testThread.start();

        new Thread(() -> System.out.println(Colors.RED.getColor() +"new Thread running")).start();

        Thread runnableThread = new Thread(new TestRunnable());
        runnableThread.start();
    }

    @Test
    public void testRunnable2() {
        TestRunnable2 testRunnable2 = new TestRunnable2();
        testRunnable2.loopRunnable();
    }

    @Test
    public void testRunnable2ExecutorsService() {
        TestRunnable2 testRunnable2 = new TestRunnable2();
        testRunnable2.loopRunnableExecutorsService();

        testRunnable2.loopRunnableFixedThreadPool();
    }

    @Test
    public void testRunnable2FixedThreadPool() {
        TestRunnable2 testRunnable2 = new TestRunnable2();
        testRunnable2.loopRunnableFixedThreadPool();
    }

    @Test
    public void testcallablel() throws ExecutionException, InterruptedException, TimeoutException {
        TestCallable testCallable = new TestCallable();
        testCallable.loopCallable(200);
    }

    @Test
    public void testcallablelTimeout() {
        TestCallable testCallable = new TestCallable();
        Exception exception = assertThrows(TimeoutException.class, () -> {
            testCallable.loopCallable(400);
        });
        assertEquals("java.util.concurrent.TimeoutException", exception.toString());
    }

    @Test
    public void testCallableThrowsException() {
        TestCallable testCallable = new TestCallable();
        Exception exception = assertThrows(ExecutionException.class, () -> {
           testCallable.loopCallableThrowsException(200);
        });
        assertEquals("java.lang.IllegalStateException: I throw this exception in : pool-1-thread-1", exception.getMessage());
    }
}
