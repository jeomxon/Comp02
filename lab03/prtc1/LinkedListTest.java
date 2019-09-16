package lab03.prtc1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Zero");
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.set(2, "ตั");
		list.remove(3);
		System.out.println(list);
		
		Iterator<String> e = list.iterator();
		
		while(e.hasNext()) {
			String s = e.next();
			System.out.println(s);
		}
	}
}
