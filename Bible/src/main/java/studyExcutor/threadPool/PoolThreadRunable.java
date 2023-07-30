package studyExcutor.threadPool;

public class PoolThreadRunable implements Runnable {
    private int num = 0;
    PoolThreadRunable(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println("Thread Test: "
                + Thread.currentThread().getName()
                + ", num: " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
