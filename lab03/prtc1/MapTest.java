package lab03.prtc1;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<>();
		
		st.put("20190001", new Student(20190001, "유비"));
		st.put("20190002", new Student(20190002, "관우"));
		st.put("20190003", new Student(20190003, "장비"));
		
		//모든 항목을 출력
		System.out.println(st);
		
		//하나의 항목을 삭제
		st.remove("20190002");
		//하나의 항목을 대체
		st.put("20190003", new Student(20190003, "조운"));
		
		for(Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
