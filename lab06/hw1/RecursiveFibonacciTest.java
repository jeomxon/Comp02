package lab06.hw1;

public class RecursiveFibonacciTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(recursiveFibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0+"√ ");
	}
	
	public static long recursiveFibonacci(int n) {
		if (n < 2) {
			return n;
		}
		else {
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		}
	}
}
