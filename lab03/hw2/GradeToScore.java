/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.09.17
 * 목적  : 학점이 알파벳으로 주어지면 실수로 반환해주는 프로그램
 *  
 ***************************/

package lab03.hw2;

import java.util.*;

public class GradeToScore {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 스캐너 객체 생성
		
		ArrayList<String> gradeList = new ArrayList<>(); // gradeList라는 이름의 ArrayList<String>객체를 생성 
		
		String input;
		
		do {
			System.out.print("학점을 입력하세요(A, B, C, D, F): ");
			input = scan.nextLine();
			if(input.equals("A") || 
				input.equals("B") || 
				input.equals("C") || 
				input.equals("D") || 
				input.equals("F") ||
				input.equals("a") ||
				input.equals("b") ||
				input.equals("c") ||
				input.equals("d") ||
				input.equals("f") ) { // 각각의 알파벳 일때 gradeList에 add메소드를 통해서 스캐너로 받은 input값을 넣어줌
				gradeList.add(input.toUpperCase()); // toUpperCase를 이용해서 저장된 학점을 모두 대문자로 바꿔주어 출력하기 위함
			}
			else if(input.equals("")) {
				break;
			} // 엔터를 입력했을 때 break
			else {
				System.out.println("잘못된 학점 입력입니다.");
			} // 그 외의 경우일 때 에러 메시지 출력
			
		} while(!(input.equals(""))); // do-while문을 사용해서 엔터를 치면 끝나게 만듦
		System.out.println("-------------------------------------");
		for (int i = 0; i < gradeList.size(); i++) {
			System.out.println("저장된 학점: " + gradeList.get(i) + " 변환한 점수: " + gradeToScore(gradeList.get(i)));
		} // for문을 통해서 gradeList에 있는 학점과 gradeToScore라는 메소드에서의 점수를 가져온다
		scan.close();
	}
	
	public static double gradeToScore(String grade) {
		Map<String, Double> st = new HashMap<>(); // HashMap객체 생성
		
		st.put("A", 4.0);
		st.put("B", 3.0);
		st.put("C", 2.0);
		st.put("D", 1.0);
		st.put("F", 0.0); // st라는 HashMap객체에 put을 통해서 key값과 value값을 지정해준다
		
		return st.get(grade); // double로 static 메소드를 만들어줘서 return값을 get메소드를 통해 key값인 grade를 넣어 value값을 반환해준다
	}
}

