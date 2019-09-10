/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.09.10
 * 목적  : 실수와 정수의 배열을 통하여 평균을 구하는 프로그램
 *  
 ***************************/

package lab02.hw1;

public class MyMath<T extends Number> { // extends Number를 사용하여서 Number의 하위만 사용될 수 있도록 범위를 지정해줌
	public double getAverage(T[] array) {
		double sum = 0.0; // 합을 저장할 변수를 선언하고 초기화
		double average; // 평균을 저장할 변수를 선언
		for (int i = 0; i < array.length; i++) {
			sum += array[i].doubleValue(); //doubleValue메소드를 사용하여 실수형으로 변환
		} // for문을 통해서 입력받는 배열의 각 수를 sum에 더하여 저장
		average = sum / array.length; // 합을 길이로 나누어 평균을 구함
		
		return average; // 평균 값을 반환
	}
}
