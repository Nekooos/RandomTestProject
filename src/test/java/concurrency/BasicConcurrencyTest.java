package concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static concurrency.ThreadColor.ANSI_GREEN;
import static concurrency.ThreadColor.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        new Thread(() -> System.out.println(ANSI_GREEN+"new Thread running")).start();

        Thread runnableThread = new Thread(new TestRunnable());
        runnableThread.start();




    }
}
