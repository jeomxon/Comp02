/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.09.17
 * 목적  : One-hot encoding을 하기 위한 프로그램
 *  
 ***************************/

package lab03.hw1;

import java.util.*;

public class StringOneHot {
	String str;
	Set<String> strSet;
	Map<Integer, String> strMap;
	Map<String, ArrayList<Integer>> strOneHotVec; //필드 선언
	
	public StringOneHot(String str) { // Hello라는 String을 받아오기 때문에 String parameter을 준다.
		int setCount = 0;
		this.str = str; // 초기화
		this.strSet = new TreeSet<>(); // Set변수를 TreeSet으로
		this.strMap = new HashMap<>(); // Map변수를  HashMap으로
		this.strOneHotVec = new HashMap<>(); // 
		
		for (int i = 0; i < str.length() ; i++) {
			if(strSet.add(Character.toString(str.charAt(i)))) { // add에 String으로 변환을 시키기 위해서 Character라는 wrapper클래스에 있는 toString메소드를 사용하고 charAt메소드를 이용하여 str에 저장된 문자열을 읽어줄 때를 조건으로 설정한다
				strMap.put(setCount, Character.toString(str.charAt(i))); // if문의 조건이 만족한다면 strMap에 put을 써서 대입하는데 i를 쓰지않고 setCount라는 변수를 따로 만들어서 Map에 출력되는 키 값의 오류를 잡아주고 value값을 넣어준다.
				setCount++;
			}
		} // 생성자에서 for문을 통해서 Hello를 체크한다
	} // 생성자
	public String getString() {
		return str;
	} // str을 반환하는 메소드
	public Set<String> getStrSet() {
		return strSet;
	} // strSet을 반환하는 메소드
	public Map<Integer, String> getStrMap() {
		return strMap;
	} // strMap을 반환하는 메소드
	public Map<String, ArrayList<Integer>> getStrOneHotVec() {
		String s;
		Iterator e = strSet.iterator();
		int count = 0; // count를 세는 변수를 따로 만들어 주어서 index를 체크함
		while(e.hasNext()) {
			s = (String)e.next(); //
			strOneHotVec.put(s, getValue(count));
			count++;
		}
		return strOneHotVec;
	} // 반복자를 사용해서 key값에 접근을 해주고 value에 getValue라는 함수를 만들어서 put에 대입함
	public ArrayList<Integer> getValue(int index) {
		ArrayList<Integer> vector = new ArrayList<>(); // vector라는 이름의 ArrayList<Integer> 객체를 생성
		int key = 0;
		for (int i = 0; i < strSet.size(); i++) {
			if (key == index) { // 늘어나는 key값과 index의 값이 같다면 1을 ArrayList에 넣어준다.
				vector.add(1);
			}
			else { // 조건이 만족하지 않다면 ArrayList에 0을 넣어준다.
				vector.add(0);
			}
			key++; // key값을 계속 증가시켜서 파라미터로 받은 index와 비교한다
		}
		return vector; // 각 문자에 맞는 ArrayList를 반환
	}
}
