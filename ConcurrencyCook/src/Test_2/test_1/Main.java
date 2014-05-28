package Test_2.test_1;

public class Main {
	public static void main(String args[]){
		Account account = new Account();
		account.setBalance(1000);
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		System.out.printf("Account : Initial Balance: %f\n",account.getBalance());
		bankThread.start();
		companyThread.start();
		try{
			bankThread.join();
			companyThread.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Account : final Balance: %f\n",account.getBalance());
	}
}
