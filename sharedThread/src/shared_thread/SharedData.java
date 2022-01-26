package shared_thread;

public class SharedData {
	private boolean isReady;
	private int oneToTowCnt;
	private int towToOneCnt;
	
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public int getOneToTowCnt() {
		return oneToTowCnt;
	}
	public void setOneToTowCnt(int oneToTowCnt) {
		this.oneToTowCnt = oneToTowCnt;
	}
	public int getTowToOneCnt() {
		return towToOneCnt;
	}
	public void setTowToOneCnt(int towToOneCnt) {
		this.towToOneCnt = towToOneCnt;
	}
}
