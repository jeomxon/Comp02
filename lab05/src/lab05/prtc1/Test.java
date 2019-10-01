/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW02
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.01
 * 목적  : ArrayList와 LinkedList의 성능차이를 비교하기 위함
 *
 ***************************/

package lab05.prtc1;

import lab04.prtc1.List;
import lab04.prtc2.ArrayList;

public class Test {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		List<Integer> ll = new LinkedList<>();
		
		//addLast메소드 비교
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			al.addLast(i);
		}
		long end1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			ll.addLast(i);
		}
		long end2 = System.currentTimeMillis();
		
		//add메소드 비교
		long start3 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			al.add(i, (int)(Math.random()*1000)+1);
		}
		long end3 = System.currentTimeMillis();
		
		long start4 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			ll.add(i, (int)(Math.random()*1000)+1);
		}
		long end4 = System.currentTimeMillis();
		
		//get메소드 비교
		long start5 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			al.get((int)(Math.random()*10000)+1);
		}
		long end5 = System.currentTimeMillis();
		
		long start6 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			ll.get((int)(Math.random()*10000)+1);
		}
		long end6 = System.currentTimeMillis();
		
		//remove메소드 비교
		long start7 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			al.remove((int)(Math.random()*1000)+1);
		}
		long end7 = System.currentTimeMillis();
		
		long start8 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			ll.remove((int)(Math.random()*1000)+1);
		}
		long end8 = System.currentTimeMillis();
		
		//addFirst메소드 비교
		long start9 = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			al.addFirst(i);
		}
		long end9 = System.currentTimeMillis();
		
		long start10 = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			ll.addFirst(i);
		}
		long end10 = System.currentTimeMillis();
		
		System.out.print("ArrayList addLast: " + (end1 - start1)/1000.0+"초  ");
		System.out.println("LinkedList addLast: " + (end2 -start2)/1000.0+"초");
		System.out.print("ArrayList add: " + (end3 - start3)/1000.0+"초  ");
		System.out.println("LinkedList add: " + (end4 - start4)/1000.0+"초");
		System.out.print("ArrayList addFirst: " + (end9 - start9)/1000.0+"초  ");
		System.out.println("LinkedList addFirst: " + (end10 - start10)/1000.0+"초");

		System.out.print("ArrayList get: " + (end5 - start5)/1000.0+"초  ");
		System.out.println("LinkedList get: " + (end6 - start6)/1000.0+"초");
		System.out.print("ArrayList remove: " + (end7 - start7)/1000.0+"초  ");
		System.out.println("LinkedList remove: " + (end8 - start8)/1000.0+"초");
		
		/**
		         --실행결과--
		    ArrayList addLast: 0.008초  LinkedList addLast: 0.01초
			ArrayList add: 0.917초  LinkedList add: 0.003초
			ArrayList addFirst: 124.53초  LinkedList addFirst: 0.009초
			ArrayList get: 0.001초  LinkedList get: 0.119초
			ArrayList remove: 1.107초  LinkedList remove: 0.001초
		 	이 결과에 따르면 addLast는 ArrayList나 LinkedList나 성능에 있어서는 거의 차이가 없음을 알 수 있다.
		 	add메소드를 사용했을 때는 임의의 숫자를 삽입하기 때문에 ArrayList는 배열을 뒤로 밀어내는데 있어서 속도가 오래 걸려서 성능차이를 느낄 수 있다.
		 	addFirst메소드를 사용했을 때는 매 시행마다 배열을 뒤로 밀어내는 작업을 하기때문에 성능차이가 확연하게 드러났다.
		 	get메소드를 사용했을 때는 ArrayList는 엄청나게 빠른 속도로 찾아냈고, LinkedList는 그에 비해 속도가 뒤쳐지게 되었다.
		 	remove메소드를 사용했을 때는  ArrayList는 임의의 인덱스에 있는 원소를 삭제하고 배열을 다시 이동시켜야하므로 시간이 오래걸리지만 
		 	LinkedList는 원소를 삭제시키고 노드만 연결시키면 되므로 시간이 상대적으로 많이 소요되지 않음을 볼 수 있다.
		 
		 **/
	}
}
