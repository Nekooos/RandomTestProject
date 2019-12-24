package concurrency;

import java.util.Random;

public class Delay {
    private final Random random = new Random();
    private final Integer MAX_WORK_TIME = 2000;
    public long pretendToWorkHard() {
        int durationInMillisconds = random.nextInt(MAX_WORK_TIME);
        try {
            Thread.sleep(durationInMillisconds);
        } catch(InterruptedException e) {

        }
        return durationInMillisconds;
    }
}
