package concurrency;

import static concurrency.ThreadColor.ANSI_BLUE;

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Runnable running");
    }
}
