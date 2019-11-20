package lab12.prtc05;

public class WaitNotifyExample {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		Thread producerThread = new Thread(new Producer(dataBox));
		Thread consumerThread = new Thread(new Consumer(dataBox));
		
		producerThread.start();
		consumerThread.start();
	}
}
