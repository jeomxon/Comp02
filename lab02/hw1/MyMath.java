/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.09.10
 * ����  : �Ǽ��� ������ �迭�� ���Ͽ� ����� ���ϴ� ���α׷�
 *  
 ***************************/

package lab02.hw1;

public class MyMath<T extends Number> { // extends Number�� ����Ͽ��� Number�� ������ ���� �� �ֵ��� ������ ��������
	public double getAverage(T[] array) {
		double sum = 0.0; // ���� ������ ������ �����ϰ� �ʱ�ȭ
		double average; // ����� ������ ������ ����
		for (int i = 0; i < array.length; i++) {
			sum += array[i].doubleValue(); //doubleValue�޼ҵ带 ����Ͽ� �Ǽ������� ��ȯ
		} // for���� ���ؼ� �Է¹޴� �迭�� �� ���� sum�� ���Ͽ� ����
		average = sum / array.length; // ���� ���̷� ������ ����� ����
		
		return average; // ��� ���� ��ȯ
	}
}
