package Test_2.test_1;

public class Company implements Runnable {
	private Account account;
	public Company(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			this.account.addAmount(1000D);
		}
	}

}
