package lab02.practice3;

import lab02.practice2.OrderedPair;
import lab02.practice2.Pair;

public class CompareGenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new OrderedPair<Integer, String>(1, "���");
		Pair<Integer, String> p2 = new OrderedPair<>(1, "���");
		Pair<Integer, String> p3 = new OrderedPair<>(2, "��");
		
		boolean result1 = Utility.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("�������� ������ ��ü�Դϴ�.");
		}
		else {
			System.out.println("�������� �������� ���� ��ü�Դϴ�.");
		}
		
		boolean result2 = Utility.compare(p2, p3);
		if(result2) {
			System.out.println("�������� ������ ��ü�Դϴ�.");
		}
		else {
			System.out.println("�������� �������� ���� ��ü�Դϴ�.");
		}
	}
}
