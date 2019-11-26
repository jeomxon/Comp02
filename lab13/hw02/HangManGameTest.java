/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW02
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.11.26
 * 목적  : 행맨 게임
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
		
		System.out.println("행맨 게임!");
		System.out.println("(제한 횟수는 " + wordInput.length*2 +"번입니다.)");
		
		while(count != (wordInput.length*2)+1) {
			if(makeString(wordInput).equals(randomWord)) {
				break;
			}
			
			System.out.print("현재상태: ");
			for(int i = 0; i < randomWord.length(); i++) {
				System.out.print(wordInput[i]);
			}
			
			System.out.print("\n문자를 입력해주세요(한글자): ");
			String input = sc.nextLine();
			
			if(input.length() >= 2 || input.length() <= 0) {
				System.out.println("한 글자만 입력가능합니다.");
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
			System.out.println("정답을 맞추지 못했습니다.");
			System.out.println("정답: " + randomWord);
		}
		else {
			System.out.print("현재상태: ");
			for(int i = 0; i < randomWord.length(); i++) {
				System.out.print(wordInput[i]);
			}
			System.out.println("\n정답을 맞췄습니다.");
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
