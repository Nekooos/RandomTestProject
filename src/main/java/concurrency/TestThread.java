package concurrency;

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println(Colors.RED + "test thread is running");
    }
}
