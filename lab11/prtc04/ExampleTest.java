package lab11.prtc04;

import java.util.Arrays;
import java.util.List;

public class ExampleTest {
	public static void main(String[] args) {
		List<Apple> list = Arrays.asList(
				new Apple("1�� ���", Colors.GREEN),
				new Apple("2�� ���", Colors.RED),
				new Apple("3�� ���", Colors.YELLOW),
				new Apple("4�� ���", Colors.GREEN),
				new Apple("5�� ���", Colors.RED),
				new Apple("6�� ���", Colors.GREEN),
				new Apple("7�� ���", Colors.RED),
				new Apple("8�� ���", Colors.YELLOW),
				new Apple("9�� ���", Colors.GREEN),
				new Apple("10�� ���", Colors.RED)
		);
		
		FilterUtils myFilter = new FilterUtils();
		List<Apple> redAppleList = myFilter.filter(list, apple -> apple.getColor() == Colors.RED);
		
		for (Apple apple : redAppleList) {
			System.out.println(apple);
		}
	}
}
