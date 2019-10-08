/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.08
 * 목적  : 반복문을 사용해서 피보나치 함수를 구현
 *
 ***************************/

package lab06.hw1;

public class LoopFibonacciTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(loopFibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"초");
	}
	
	public static long loopFibonacci(int n) {
		long first = 1; // 첫번째를 1로 선언
		long second = 1; // 두번째를 1로 선언
		long result = -1; 
		
		if(n == 1 || n ==2) {
			return 1;
		} // n번째를 구할 때 1번째나 2번째면 1을 리턴
		else {
			for(int i = 3; i <= n; i++) {
				result = first + second;
				first = second;
				second = result;
			} // 3부터 그 이상인 경우에는 반복문을 통해서 앞의 두 수를 더해주는 작업을 계속함
			return result; // 결과값을 리턴해줌
		}
	}
}
