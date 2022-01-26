package shared_thread;


public class Main {
	public static void main(String[] args) {
		SharedData sharedData = new SharedData();
		
		TestThreadOne one = new TestThreadOne(sharedData);
		TestThreadTwo two = new TestThreadTwo(sharedData);
		
		one.start();
		two.start();
	}
}
