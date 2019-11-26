package lab13.prtc05;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ObjectOutputStreamTest {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		for(int i = 0; i < 100; i++) {
			bank.addCustomer("CNU" + i);
			bank.getCustomer(i).addAccount(new CheckingAccount(1000.0));
		}
		
		System.out.println("������ ���� �ܰ� ���� ��Ȳ");
		for(int i = 0; i < bank.getNumofCustomers(); i++) {
			Customer customer = bank.getCustomer(i);
			Account acc = customer.getAccount(0);
			System.out.println(customer.getName() + "�� �����ݾ�: " + acc.getBalance() + "��");
		}
		System.out.println("������ �� �� ��: " + bank.getNumofCustomers() + "��");
		System.out.println("������ �� �ܰ�: " + bank.getTotalBalance() + "��");
		
		ObjectOutputStream oos = null;
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("./src/lab13/prtc05/Bank.obj");
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(bank);
			oos.flush();
			oos.close();
			System.out.println("��ü ���� �Ϸ�");
		}
		catch (IOException e) {
			System.out.println("����� ���� �߻�");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("��Ÿ ���� �߻�");
		}
	}
}
