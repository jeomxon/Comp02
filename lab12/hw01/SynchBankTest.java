/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.11.20
 * ����  : �����带 �̿��� ���� �۱� �ý��� ����
 *
 ***************************/

package lab12.hw01;

public class SynchBankTest {
	public static final int NCUSTOMERS = 100;
	public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String[] args) {
		int count = 0;
		int maxAmount = 1000;
		
		Bank bank = new Bank(NCUSTOMERS);
		TransferRunnable[] customerThread = new TransferRunnable[NCUSTOMERS];
		for (int i = 0; i < NCUSTOMERS; i++) {
			bank.addCustomer("CNU" + Integer.toString(count++));
			bank.getCustomer(count-1).addAccount(new CheckingAccount(INITIAL_BALANCE));
			customerThread[i] = new TransferRunnable(bank, count - 1, maxAmount);
			
		}
		for (int i = 0; i < NCUSTOMERS; i++) {
			(new Thread(customerThread[i])).start();
		}
	}
}
