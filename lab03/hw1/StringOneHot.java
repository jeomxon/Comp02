/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.09.17
 * ����  : One-hot encoding�� �ϱ� ���� ���α׷�
 *  
 ***************************/

package lab03.hw1;

import java.util.*;

public class StringOneHot {
	String str;
	Set<String> strSet;
	Map<Integer, String> strMap;
	Map<String, ArrayList<Integer>> strOneHotVec; //�ʵ� ����
	
	public StringOneHot(String str) { // Hello��� String�� �޾ƿ��� ������ String parameter�� �ش�.
		int setCount = 0;
		this.str = str; // �ʱ�ȭ
		this.strSet = new TreeSet<>(); // Set������ TreeSet����
		this.strMap = new HashMap<>(); // Map������  HashMap����
		this.strOneHotVec = new HashMap<>(); // 
		
		for (int i = 0; i < str.length() ; i++) {
			if(strSet.add(Character.toString(str.charAt(i)))) { // add�� String���� ��ȯ�� ��Ű�� ���ؼ� Character��� wrapperŬ������ �ִ� toString�޼ҵ带 ����ϰ� charAt�޼ҵ带 �̿��Ͽ� str�� ����� ���ڿ��� �о��� ���� �������� �����Ѵ�
				strMap.put(setCount, Character.toString(str.charAt(i))); // if���� ������ �����Ѵٸ� strMap�� put�� �Ἥ �����ϴµ� i�� �����ʰ� setCount��� ������ ���� ���� Map�� ��µǴ� Ű ���� ������ ����ְ� value���� �־��ش�.
				setCount++;
			}
		} // �����ڿ��� for���� ���ؼ� Hello�� üũ�Ѵ�
	} // ������
	public String getString() {
		return str;
	} // str�� ��ȯ�ϴ� �޼ҵ�
	public Set<String> getStrSet() {
		return strSet;
	} // strSet�� ��ȯ�ϴ� �޼ҵ�
	public Map<Integer, String> getStrMap() {
		return strMap;
	} // strMap�� ��ȯ�ϴ� �޼ҵ�
	public Map<String, ArrayList<Integer>> getStrOneHotVec() {
		String s;
		Iterator e = strSet.iterator();
		int count = 0; // count�� ���� ������ ���� ����� �־ index�� üũ��
		while(e.hasNext()) {
			s = (String)e.next(); //
			strOneHotVec.put(s, getValue(count));
			count++;
		}
		return strOneHotVec;
	} // �ݺ��ڸ� ����ؼ� key���� ������ ���ְ� value�� getValue��� �Լ��� ���� put�� ������
	public ArrayList<Integer> getValue(int index) {
		ArrayList<Integer> vector = new ArrayList<>(); // vector��� �̸��� ArrayList<Integer> ��ü�� ����
		int key = 0;
		for (int i = 0; i < strSet.size(); i++) {
			if (key == index) { // �þ�� key���� index�� ���� ���ٸ� 1�� ArrayList�� �־��ش�.
				vector.add(1);
			}
			else { // ������ �������� �ʴٸ� ArrayList�� 0�� �־��ش�.
				vector.add(0);
			}
			key++; // key���� ��� �������Ѽ� �Ķ���ͷ� ���� index�� ���Ѵ�
		}
		return vector; // �� ���ڿ� �´� ArrayList�� ��ȯ
	}
}
