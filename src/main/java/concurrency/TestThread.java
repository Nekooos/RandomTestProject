package concurrency;

import static concurrency.ThreadColor.ANSI_RED;

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "test thread is running");
    }
}
