package studyExcutor.singleThread;

public class SingleThreadRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Test: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
