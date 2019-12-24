package concurrency;

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println(Colors.GREEN.getColor() + "test thread is running");
    }
}
