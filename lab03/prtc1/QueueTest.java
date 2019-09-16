package lab03.prtc1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) throws InterruptedException{
		int time = 10;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = time; i >= 0; i--) {
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.remove() + " ");
			Thread.sleep(1000);
		}
	}
}
