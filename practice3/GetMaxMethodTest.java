package lab02.practice3;

public class GetMaxMethodTest {
	public static void main(String[] args) {
		Integer[] intArray = {1, 4, 55, 9, 18};
		System.out.println(Utility.<Integer>getMax(intArray));
		String[] strArray = {"King", "Queen", "Jack", "Ten", "Ace"};
		System.out.println(Utility.<String>getMax(strArray));
	}
}
