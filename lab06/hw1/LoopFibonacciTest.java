package lab06.hw1;

public class LoopFibonacciTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(loopFibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"√ ");
	}
	
	public static long loopFibonacci(int n) {
		long first = 1;
		long second = 1;
		long result = -1;
		
		if(n == 1 || n ==2) {
			return 1;
		}
		else {
			for(int i = 3; i <= n; i++) {
				result = first + second;
				first = second;
				second = result;
			}
			return result;
		}
	}
}
