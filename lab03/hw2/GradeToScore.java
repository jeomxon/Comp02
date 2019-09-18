/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.09.17
 * ����  : ������ ���ĺ����� �־����� �Ǽ��� ��ȯ���ִ� ���α׷�
 *  
 ***************************/

package lab03.hw2;

import java.util.*;

public class GradeToScore {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // ��ĳ�� ��ü ����
		
		ArrayList<String> gradeList = new ArrayList<>(); // gradeList��� �̸��� ArrayList<String>��ü�� ���� 
		
		String input;
		
		do {
			System.out.print("������ �Է��ϼ���(A, B, C, D, F): ");
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
				input.equals("f") ) { // ������ ���ĺ� �϶� gradeList�� add�޼ҵ带 ���ؼ� ��ĳ�ʷ� ���� input���� �־���
				gradeList.add(input.toUpperCase()); // toUpperCase�� �̿��ؼ� ����� ������ ��� �빮�ڷ� �ٲ��־� ����ϱ� ����
			}
			else if(input.equals("")) {
				break;
			} // ���͸� �Է����� �� break
			else {
				System.out.println("�߸��� ���� �Է��Դϴ�.");
			} // �� ���� ����� �� ���� �޽��� ���
			
		} while(!(input.equals(""))); // do-while���� ����ؼ� ���͸� ġ�� ������ ����
		System.out.println("-------------------------------------");
		for (int i = 0; i < gradeList.size(); i++) {
			System.out.println("����� ����: " + gradeList.get(i) + " ��ȯ�� ����: " + gradeToScore(gradeList.get(i)));
		} // for���� ���ؼ� gradeList�� �ִ� ������ gradeToScore��� �޼ҵ忡���� ������ �����´�
		scan.close();
	}
	
	public static double gradeToScore(String grade) {
		Map<String, Double> st = new HashMap<>(); // HashMap��ü ����
		
		st.put("A", 4.0);
		st.put("B", 3.0);
		st.put("C", 2.0);
		st.put("D", 1.0);
		st.put("F", 0.0); // st��� HashMap��ü�� put�� ���ؼ� key���� value���� �������ش�
		
		return st.get(grade); // double�� static �޼ҵ带 ������༭ return���� get�޼ҵ带 ���� key���� grade�� �־� value���� ��ȯ���ش�
	}
}

