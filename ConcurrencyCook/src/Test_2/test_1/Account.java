package Test_2.test_1;

import java.util.concurrent.TimeUnit;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public synchronized void addAmount(Double amount){
		double tmp = 0D;
		tmp = balance;
		try{
			Thread.sleep(10);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}
	
	public synchronized void subtractAmount(Double amount){
		double tmp = 0D;
		tmp = balance;
		try{
			Thread.sleep(10);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
}
