package lab03.hw1;

public class StringOneHotTest {
	public static void main(String[] args) {
		
		String str = "Hello";
		StringOneHot soh = new StringOneHot(str);
		System.out.println("���ڿ�: " + soh.getString());
		System.out.println("���ڿ� Set: " + soh.getStrSet());
		System.out.println("���ڿ� Map: " + soh.getStrMap());
		System.out.println("���ڿ� One-hot Vector: " + soh.getStrOneHotVec());
		
		System.out.println("One-hot Vector�� ��Ÿ�� " + soh.getString());
		for (int i = 0; i < str.length(); i++) {
			System.out.println(soh.getStrOneHotVec().get(str.substring(i, i+1)));
		}
		
	}
}
