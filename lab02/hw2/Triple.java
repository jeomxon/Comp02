/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.09.10
 * 목적  : 제네릭을 사용하여 똑같은 타입의 객체 3개를 저장하고 출력하는 프로그램
 *  
 ***************************/


package lab02.hw2;

public class Triple<T> {
	private T first; // 첫번째 변수 선언
	private T second; // 두번째 변수 선언
	private T third; // 세번째 변수 선언

	public Triple(T first, T second, T third) {
		this.first = first; // 첫번째 변수 초기화
		this.second = second; // 두번째 변수 초기화
		this.third = third; // 세번째 변수 초기화
	} // 생성자

	public T getFirst() {
		return first;
	} // 접근자 

	public void setFirst(T first) {
		this.first = first;
	} // 설정자

	public T getSecond() {
		return second;
	} // 접근자

	public void setSecond(T second) {
		this.second = second;
	} // 설정자

	public T getThird() {
		return third;
	} // 접근자

	public void setThird(T third) {
		this.third = third;
	} // 설정자

	public String toString() {
		return "First: " + first + ", Second: " + second + ", Third: " + third;
	} // toString 메소드를 재정의

}
