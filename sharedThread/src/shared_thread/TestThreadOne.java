package shared_thread;

public class TestThreadOne extends Thread {
	SharedData sharedData;
	
	public TestThreadOne(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	public void run() {
		System.out.println("Send Data int 100");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sharedData.setOneToTowCnt(100);
		sharedData.setReady(true);
	}
}
