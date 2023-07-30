package studyFuture.callable;

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<Integer> {
    private int num = 0;

    ThreadPoolCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread Test: "
                + Thread.currentThread().getName()
                + ", num: " + num);
        return num + 10;
    }
}
