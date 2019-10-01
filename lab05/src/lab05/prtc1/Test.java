/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.01
 * ����  : ArrayList�� LinkedList�� �������̸� ���ϱ� ����
 *
 ***************************/

package lab05.prtc1;

import lab04.prtc1.List;
import lab04.prtc2.ArrayList;

public class Test {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		List<Integer> ll = new LinkedList<>();
		
		//addLast�޼ҵ� ��
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
		
		//add�޼ҵ� ��
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
		
		//get�޼ҵ� ��
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
		
		//remove�޼ҵ� ��
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
		
		//addFirst�޼ҵ� ��
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
		
		System.out.print("ArrayList addLast: " + (end1 - start1)/1000.0+"��  ");
		System.out.println("LinkedList addLast: " + (end2 -start2)/1000.0+"��");
		System.out.print("ArrayList add: " + (end3 - start3)/1000.0+"��  ");
		System.out.println("LinkedList add: " + (end4 - start4)/1000.0+"��");
		System.out.print("ArrayList addFirst: " + (end9 - start9)/1000.0+"��  ");
		System.out.println("LinkedList addFirst: " + (end10 - start10)/1000.0+"��");

		System.out.print("ArrayList get: " + (end5 - start5)/1000.0+"��  ");
		System.out.println("LinkedList get: " + (end6 - start6)/1000.0+"��");
		System.out.print("ArrayList remove: " + (end7 - start7)/1000.0+"��  ");
		System.out.println("LinkedList remove: " + (end8 - start8)/1000.0+"��");
		
		/**
		         --������--
		    ArrayList addLast: 0.008��  LinkedList addLast: 0.01��
			ArrayList add: 0.917��  LinkedList add: 0.003��
			ArrayList addFirst: 124.53��  LinkedList addFirst: 0.009��
			ArrayList get: 0.001��  LinkedList get: 0.119��
			ArrayList remove: 1.107��  LinkedList remove: 0.001��
		 	�� ����� ������ addLast�� ArrayList�� LinkedList�� ���ɿ� �־�� ���� ���̰� ������ �� �� �ִ�.
		 	add�޼ҵ带 ������� ���� ������ ���ڸ� �����ϱ� ������ ArrayList�� �迭�� �ڷ� �о�µ� �־ �ӵ��� ���� �ɷ��� �������̸� ���� �� �ִ�.
		 	addFirst�޼ҵ带 ������� ���� �� ���ึ�� �迭�� �ڷ� �о�� �۾��� �ϱ⶧���� �������̰� Ȯ���ϰ� �巯����.
		 	get�޼ҵ带 ������� ���� ArrayList�� ��û���� ���� �ӵ��� ã�Ƴ°�, LinkedList�� �׿� ���� �ӵ��� �������� �Ǿ���.
		 	remove�޼ҵ带 ������� ����  ArrayList�� ������ �ε����� �ִ� ���Ҹ� �����ϰ� �迭�� �ٽ� �̵����Ѿ��ϹǷ� �ð��� �����ɸ����� 
		 	LinkedList�� ���Ҹ� ������Ű�� ��常 �����Ű�� �ǹǷ� �ð��� ��������� ���� �ҿ���� ������ �� �� �ִ�.
		 
		 **/
	}
}
