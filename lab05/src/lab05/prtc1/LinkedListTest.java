package lab05.prtc1;

import lab04.prtc1.*;
import lab04.prtc2.Iterator;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < 100000; i++) {
			list.addLast(i);
		}
		long start = System.currentTimeMillis();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"√ ");
	}
}
