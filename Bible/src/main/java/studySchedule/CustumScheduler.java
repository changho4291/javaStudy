package studySchedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CustumScheduler {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        List<ScheduledFuture<?>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureList.add(executorService.scheduleAtFixedRate((Runnable) new ScheduleRunnable(i), 0, 5, TimeUnit.SECONDS));
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("num : " + i + " is cancle");
                futureList.get(i).cancel(true);
            }
        }
        futureList.clear();

        System.out.println("===========restart===========");

        for (int i = 0; i < 10; i++) {
            futureList.add(executorService.scheduleAtFixedRate((Runnable) new ScheduleRunnable(i), 0, 5, TimeUnit.SECONDS));
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("num : " + i + " is cancle");
                futureList.get(i).cancel(true);
            }
        }
        futureList.clear();
        executorService.shutdown();
    }
}
