package lab06.prtc2;

import java.util.ArrayList;

public class RecurSearchTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			list.add(i);
		}
		
		System.out.println("find 50: " + sequentialSearch(list, 50, 0, list.size() - 1));
		System.out.println("find 100: " + sequentialSearch(list, 100, 0, list.size() - 1));
	}
	
	public static <T> int sequentialSearch(ArrayList<T> list, T target, int begin, int end) {
		if(begin <= end) {
			if(list.get(begin) == target) {
				return begin;
			}
			return sequentialSearch(list, target, begin + 1, end);
		}
		else {
			return -1;
		}
	}
	
}
