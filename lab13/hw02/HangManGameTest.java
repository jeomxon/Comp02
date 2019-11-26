/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.11.26
 * ����  : ��� ����
 *
 ***************************/

package lab13.hw02;

import java.io.IOException;
import java.util.Scanner;

public class HangManGameTest {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	
		String randomWord = (new Word()).getRandomWord();
		String[] wordInput = new String[randomWord.length()];
		int count = 1;
		
		for(int i = 0; i < randomWord.length(); i++) {
			wordInput[i] = "_ ";
		}
		
		System.out.println("��� ����!");
		System.out.println("(���� Ƚ���� " + wordInput.length*2 +"���Դϴ�.)");
		
		while(count != (wordInput.length*2)+1) {
			if(makeString(wordInput).equals(randomWord)) {
				break;
			}
			
			System.out.print("�������: ");
			for(int i = 0; i < randomWord.length(); i++) {
				System.out.print(wordInput[i]);
			}
			
			System.out.print("\n���ڸ� �Է����ּ���(�ѱ���): ");
			String input = sc.nextLine();
			
			if(input.length() >= 2 || input.length() <= 0) {
				System.out.println("�� ���ڸ� �Է°����մϴ�.");
			}
			
			for(int i = 0; i < randomWord.length(); i++) {
				char c = randomWord.charAt(i);
				String s = String.valueOf(c);
				
				if(input.equals(s.toLowerCase())) {
					
					if(input.equals(s)) {
						wordInput[i] = input;
					}
					else {
						wordInput[i] = input.toUpperCase();
					}
				}
				else if (input.equals(s.toUpperCase())){
					if(input.equals(s)) {
						wordInput[i] = input;
					}
					else {
						wordInput[i] = input.toLowerCase();
					}
				}
			}
			count++;
		}
		
		if(count == wordInput.length*2+1) {
			System.out.println("������ ������ ���߽��ϴ�.");
			System.out.println("����: " + randomWord);
		}
		else {
			System.out.print("�������: ");
			for(int i = 0; i < randomWord.length(); i++) {
				System.out.print(wordInput[i]);
			}
			System.out.println("\n������ ������ϴ�.");
		}
		
	}
	private static String makeString(String[] s) {
		
		String str = "";
		for(int i = 0; i < s.length; i++) {
			str += s[i];
		}
		
		return str;
	}
}
