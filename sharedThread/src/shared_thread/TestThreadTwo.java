package shared_thread;

public class TestThreadTwo extends Thread {
	SharedData sharedData;
	
	public TestThreadTwo(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	public void run() {
		int cnt = 0;
		
		while(true) {
			cnt++;
			
			try {
				Thread.sleep(1000);
				System.out.println("스레드 수행 횟수: " + cnt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(sharedData.isReady()) {
				System.out.println("받은 데이터: " + sharedData.getOneToTowCnt());
				break;
			}
		}
	}
}
