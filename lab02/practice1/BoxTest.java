package lab02.practice1;

public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("Java"); // String->Object(자동타입변환)
		String language = (String) box.get(); // Object->String(강제타입변환)
		
		box.set(new Integer(10)); // Integer->Object(자동타입변환)
		Integer number = (Integer) box.get(); // Object->Integer(강제타입변환)
		
		box.set(true); // boolean->Boolean(AutoBoxing)->Object(자동타입변환)
		boolean flag = (boolean) box.get(); // Object ->Boolean(강제타입변환)->boolean(AutoUnboxing)
		
		box.set("Hello world!");
		Integer i = (Integer) box.get(); // 런타임 오류 발생!
	}
}
