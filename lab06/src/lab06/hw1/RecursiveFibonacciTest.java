/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.08
 * 목적  : 재귀호출을 사용해서 피보나치 함수를 구현
 *
 ***************************/

package lab06.hw1;

public class RecursiveFibonacciTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(recursiveFibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"초");
	}
	
	public static long recursiveFibonacci(int n) {
		if (n < 2) {
			return n;
		} // n이 2보다 작으면 n을 리턴
		else {
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		} // 재귀를 이용하여 앞의 두 수를 더해줌
	}
}
