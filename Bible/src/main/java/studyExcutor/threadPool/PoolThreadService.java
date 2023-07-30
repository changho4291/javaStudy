package studyExcutor.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThreadService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 10; i++) {
            executorService.submit(new PoolThreadRunable(i));
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
