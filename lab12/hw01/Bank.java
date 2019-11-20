package lab12.hw01;

public class Bank {
	Customer[] customer;
	private int numOfCustomer;
	// private Lock bankLock;

	public Bank(int ncus) {
		customer = new Customer[ncus];
		numOfCustomer = 0;
		// bankLock = new ReentrantLock();
	}

	public void addCustomer(String name) {
		customer[numOfCustomer] = new Customer(name);
		numOfCustomer++;
	}

	public int getNumofCustomers() {
		return numOfCustomer;
	}

	public Customer getCustomer(int index) {
		return customer[index];
	}

	public synchronized void transfer(int from, int to, double amount) {
		while (true) {
			if (customer[from].getAccount(0).getBalance() < amount) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			} else {
				break;
			}
		}

		customer[from].getAccount(0).withdraw(amount);
		customer[to].getAccount(0).deposit(amount);
		System.out.print(customer[from].getName() + " 계좌에서 " + customer[to].getName() + " 계좌로 " + String.format("%,d", (int) amount) + "원 송금,"); 
		System.out.println("은행의 총 보유 금액: " + String.format("%,d", (int) getTotalBalance()) + "원");
		notifyAll();

	}

	public double getTotalBalance() {
		double totalBalance = 0;
		for (int i = 0; i < numOfCustomer; i++) {
			totalBalance += customer[i].getAccount(0).getBalance();
		}
		return totalBalance;
	}
}
