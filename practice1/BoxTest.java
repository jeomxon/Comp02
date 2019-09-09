package lab02.practice1;

public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("Java"); // String->Object(�ڵ�Ÿ�Ժ�ȯ)
		String language = (String) box.get(); // Object->String(����Ÿ�Ժ�ȯ)
		
		box.set(new Integer(10)); // Integer->Object(�ڵ�Ÿ�Ժ�ȯ)
		Integer number = (Integer) box.get(); // Object->Integer(����Ÿ�Ժ�ȯ)
		
		box.set(true); // boolean->Boolean(AutoBoxing)->Object(�ڵ�Ÿ�Ժ�ȯ)
		boolean flag = (boolean) box.get(); // Object ->Boolean(����Ÿ�Ժ�ȯ)->boolean(AutoUnboxing)
		
		box.set("Hello world!");
		Integer i = (Integer) box.get(); // ��Ÿ�� ���� �߻�!
	}
}
