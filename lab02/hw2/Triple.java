/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.09.10
 * ����  : ���׸��� ����Ͽ� �Ȱ��� Ÿ���� ��ü 3���� �����ϰ� ����ϴ� ���α׷�
 *  
 ***************************/


package lab02.hw2;

public class Triple<T> {
	private T first; // ù��° ���� ����
	private T second; // �ι�° ���� ����
	private T third; // ����° ���� ����

	public Triple(T first, T second, T third) {
		this.first = first; // ù��° ���� �ʱ�ȭ
		this.second = second; // �ι�° ���� �ʱ�ȭ
		this.third = third; // ����° ���� �ʱ�ȭ
	} // ������

	public T getFirst() {
		return first;
	} // ������ 

	public void setFirst(T first) {
		this.first = first;
	} // ������

	public T getSecond() {
		return second;
	} // ������

	public void setSecond(T second) {
		this.second = second;
	} // ������

	public T getThird() {
		return third;
	} // ������

	public void setThird(T third) {
		this.third = third;
	} // ������

	public String toString() {
		return "First: " + first + ", Second: " + second + ", Third: " + third;
	} // toString �޼ҵ带 ������

}
