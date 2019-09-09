package lab02.practice1;

public class GenericBoxTest {
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<>();
		box1.set("Á¦³×¸¯");
		System.out.println("box1 = " + box1.get());
		
		GenericBox<Integer> box2 = new GenericBox<>();
		box2.set(10);
		System.out.println("box2 = " + box2.get());
		
		GenericBox<String> box3 = new GenericBox<>();
		box3.set("true");
		System.out.println("box3 = " + box3.get());
	}
}
