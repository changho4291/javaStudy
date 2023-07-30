package studyFuture.timeout;

import java.time.LocalTime;
import java.util.concurrent.*;

public class FutureTimeout {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int num = 3;
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Thread Test: "
                    + Thread.currentThread().getName()
                    + ", num: " + num);
            Thread.sleep(3000);
            return num + 10;
        });

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result = null;

        try {
            result = future.get(1, TimeUnit.SECONDS);
            System.out.println(LocalTime.now() + " Result : " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
