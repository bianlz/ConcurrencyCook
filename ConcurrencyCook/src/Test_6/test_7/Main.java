package Test_6.test_7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setBalance(1000L);
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		System.out.printf("Account : Initial balance :%s \n",account.getBalance().toString());
		companyThread.start();
		bankThread.start();
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : final balance :%s \n",account.getBalance().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
