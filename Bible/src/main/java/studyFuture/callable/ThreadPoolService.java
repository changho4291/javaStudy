package studyFuture.callable;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> future = executorService.submit(new studyFuture.callable.ThreadPoolCallable(3));

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result = null;

        try {
            result = future.get();
            System.out.println(LocalTime.now() + " Result : " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
