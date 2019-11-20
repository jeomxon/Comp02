package lab12.hw01;

public class TransferRunnable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private final int DELAY = 10;
	
	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}
	
	@Override
	public void run() {
		
		while(true) {
			int delayTime = (int)Math.random() * DELAY;
			try {
				Thread.sleep(delayTime);
			} 
			catch (InterruptedException e) {}
			
			int toAccount = (int) (Math.random() * bank.getNumofCustomers());
			int amount = (int) (Math.random() * maxAmount);
			bank.transfer(fromAccount, toAccount, amount);
		}
	}
}
