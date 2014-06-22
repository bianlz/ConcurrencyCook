package Test_6.test_7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Account {
	private AtomicLong balance;
	public Account(){
		this.balance = new AtomicLong();
	}
	public AtomicLong getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance.set(balance);
	}
	public void addAmount(Long amount){
		this.balance.getAndAdd(amount);
	}
	public void subtractAmount(Long amount){
		this.balance.getAndAdd(-amount);
	}
}
