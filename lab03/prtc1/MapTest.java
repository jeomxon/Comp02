package lab03.prtc1;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<>();
		
		st.put("20190001", new Student(20190001, "����"));
		st.put("20190002", new Student(20190002, "����"));
		st.put("20190003", new Student(20190003, "���"));
		
		//��� �׸��� ���
		System.out.println(st);
		
		//�ϳ��� �׸��� ����
		st.remove("20190002");
		//�ϳ��� �׸��� ��ü
		st.put("20190003", new Student(20190003, "����"));
		
		for(Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
