package concurrency;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Colors.BLUE.getColor() + "Runnable running");
    }
}
