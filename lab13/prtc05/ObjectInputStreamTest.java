package lab13.prtc05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		
		Bank bank = null;
		try {
			fis = new FileInputStream("./src/lab13/prtc05/Bank.obj");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			bank = (Bank)ois.readObject();
			
			fis.close();
			bis.close();
			ois.close();
		}
		catch (IOException e) {
			System.out.println("����� ���� �߻�");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Bank Ŭ������ ã�� �� �����ϴ�.");
		}
		
		System.out.println("������ ���� �ܰ� ���� ��Ȳ");
		for(int i = 0; i < bank.getNumofCustomers(); i++) {
			Customer customer = bank.getCustomer(i);
			Account acc = customer.getAccount(0);
			System.out.println(customer.getName() + "�� �����ݾ�: " + acc.getBalance() + "��");
		}
		System.out.println("������ �� �� ��: " + bank.getNumofCustomers() + "��");
		System.out.println("������ �� �ܰ�: " + bank.getTotalBalance() + "��");
	}
}
