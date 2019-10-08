/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.08
 * ����  : �ݺ����� ��͸� ����Ͽ� �Ǻ���ġ ������ n��° ���� ����� ���� �������̸� ���ϱ� ����
 *
 ***************************/

package lab06.hw1;

import java.util.Scanner;

public class FibonacciTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�Ǻ���ġ ������ n��° ���� ����մϴ�");
		System.out.print("n ���� �Է��ϼ���: ");
		int n = scan.nextInt();
		long start1 = System.currentTimeMillis();
		System.out.println("�ݺ����� ����ؼ� ����� F(" + n + ") = " + LoopFibonacciTest.loopFibonacci(n));
		long end1 = System.currentTimeMillis();
		System.out.println("��� �ð� : " + (end1 - start1)/1000.0 + "��");
		
		long start2 = System.currentTimeMillis();
		System.out.println("���ȣ���� ����ؼ� ����� F(" + n + ") = " + RecursiveFibonacciTest.recursiveFibonacci(n));
		long end2 = System.currentTimeMillis();
		System.out.println("��� �ð� : " + (end2 - start2)/1000.0 + "��");
		
		// n�� ���� Ŀ������ ��Ϳ����� ����ӵ��� �� ���� �ɸ��� �ȴ�.
		// �ֳ��ϸ� �Լ� ȣ�⿡ �־ �䱸�ϴ� ���� �ݺ����� �ݺ��ϴ� �� ���� �� ���� ����� �ҿ�Ǳ� �����̴�.
		// ���� n�� 50������ ũ�⸦ �䱸�ϸ� ����ӵ��� �־ ����� ���̸� ���̴� ���� �� �� �ִ�.
	}
}
