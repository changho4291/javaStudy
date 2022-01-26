package shared_thread;

public class TestThreadTwo extends Thread {
	SharedData sharedData;
	
	public TestThreadTwo(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	public void run() {
		while(!sharedData.isReady()) {
			
			//if(sharedData.isReady())
			System.out.println("받은 데이터: " + sharedData.getOneToTowCnt());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//sharedData.setReady(true);
		}
	}
}
