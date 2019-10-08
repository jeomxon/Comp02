/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.08
 * 목적  : 반복문과 재귀를 사용하여 피보나치 수열의 n번째 항을 계산할 때의 성능차이를 비교하기 위함
 *
 ***************************/

package lab06.hw1;

import java.util.Scanner;

public class FibonacciTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("피보나치 수열의 n번째 항을 계산합니다");
		System.out.print("n 값을 입력하세요: ");
		int n = scan.nextInt();
		long start1 = System.currentTimeMillis();
		System.out.println("반복문을 사용해서 계산한 F(" + n + ") = " + LoopFibonacciTest.loopFibonacci(n));
		long end1 = System.currentTimeMillis();
		System.out.println("계산 시간 : " + (end1 - start1)/1000.0 + "초");
		
		long start2 = System.currentTimeMillis();
		System.out.println("재귀호출을 사용해서 계산한 F(" + n + ") = " + RecursiveFibonacciTest.recursiveFibonacci(n));
		long end2 = System.currentTimeMillis();
		System.out.println("계산 시간 : " + (end2 - start2)/1000.0 + "초");
		
		// n의 값이 커질수록 재귀에서는 실행속도가 더 오래 걸리게 된다.
		// 왜냐하면 함수 호출에 있어서 요구하는 것이 반복문을 반복하는 것 보다 더 많은 비용이 소요되기 때문이다.
		// 따라서 n이 50정도의 크기를 요구하면 실행속도에 있어서 상당한 차이를 보이는 것을 알 수 있다.
	}
}
