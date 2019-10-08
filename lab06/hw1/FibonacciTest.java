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
		
	}
}
