package lab02.practice3;

public class BoxingGenericMethodTest {
	public static void main(String[] args) {
		GenericBox<Integer> box1 = Utility.<Integer>boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);
		
		GenericBox<String>box2 = Utility.boxing("���׸� �޼ҵ�");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
