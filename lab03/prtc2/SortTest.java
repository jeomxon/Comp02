package lab03.prtc2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lab03.prtc1.Student;

public class SortTest {
	public static void main(String[] args) {
		Student array[] = {
				new Student(20190021, "�ϳ�"),
				new Student(20190043, "�ؿ�"),
				new Student(20190019, "����"),
				new Student(20190033, "����"),
		};
		
		List<Student> list = Arrays.asList(array);
		Collections.sort(list);
		System.out.println(list);
	}
}
