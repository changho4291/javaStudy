package studySchedule;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

public class ScheduleRunnable implements Runnable {
    private int num;

    public ScheduleRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        long nano = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(nano);
        System.out.println(
            "Timer Test: "
            + Thread.currentThread().getName()
            + " " + time
            + ", num = " + num
        );
    }
}
