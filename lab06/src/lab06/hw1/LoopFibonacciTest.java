/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.08
 * ����  : �ݺ����� ����ؼ� �Ǻ���ġ �Լ��� ����
 *
 ***************************/

package lab06.hw1;

public class LoopFibonacciTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(loopFibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"��");
	}
	
	public static long loopFibonacci(int n) {
		long first = 1; // ù��°�� 1�� ����
		long second = 1; // �ι�°�� 1�� ����
		long result = -1; 
		
		if(n == 1 || n ==2) {
			return 1;
		} // n��°�� ���� �� 1��°�� 2��°�� 1�� ����
		else {
			for(int i = 3; i <= n; i++) {
				result = first + second;
				first = second;
				second = result;
			} // 3���� �� �̻��� ��쿡�� �ݺ����� ���ؼ� ���� �� ���� �����ִ� �۾��� �����
			return result; // ������� ��������
		}
	}
}
