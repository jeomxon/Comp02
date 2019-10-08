/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.08
 * 목적  : 이진탐색을 구현하고 확인해봄
 *
 ***************************/

package lab06.hw2;

import java.util.ArrayList;

public class RecursiveBinarySearchTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(2 * i);
		}

		System.out.println("이진 탐색으로 150 탐색: " + binarySearch(list, 150, 0, list.size() - 1));
		System.out.println("list.get(75): " + list.get(75));
		System.out.println("이진 탐색으로 111 탐색: " + binarySearch(list, 111, 0, list.size() - 1));
	}
	/**
	public static <T> int binarySearch(ArrayList<? extends Comparable<T>> list, T target, int begin, int end) {
		int mid = (begin + end) / 2;

		if (begin > end) {
			return -1;
		} // begin이 end보다 크면 찾는 값이 없는 것으로 간주되어 -1을 리턴

		if (list.get(mid).compareTo(target) == 0) {
			return mid;
		}  // compareTo메소드로 객체를 비교해서 mid에서 가져온 값이랑 target이랑 같으면 mid값을 리턴해줌
		else if (list.get(mid).compareTo(target) > 0) {
			return binarySearch(list, target, begin, mid - 1);
		}  // mid에서 가져온 값이 target의 값보다 크면 mid-1을 end값으로 생각해주어서 이진탐색을 재귀호출
		else {
			return binarySearch(list, target, mid + 1, end);
		} // 둘다 아닌 경우에는 mid+1값을 begin값으로 생각하여 이진탐색을 재귀호출
	}
	**/
	
	public static <T> int binarySearch(ArrayList<? extends Comparable<T>> list, T target, int begin, int end) {
		int mid = (begin + end) / 2;
		
		while(end - begin >= 0) {
			if(list.get(mid).compareTo(target) == 0) {
				return mid;
			}
			else if(list.get(mid).compareTo(target) > 0) {
				end = mid - 1;
			}
			else {
				begin = mid + 1;
			}
			mid = (begin + end) / 2;
		}
		return -1;
	}
}
