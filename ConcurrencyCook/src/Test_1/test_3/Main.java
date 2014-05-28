package Test_1.test_3;

public class Main {
	public static void main(String args[]){
		Thread t = new PrimeGenerator();
		t.start();
		try{
			Thread.sleep(5000);
			t.interrupt();
		}catch(InterruptedException ex){
				System.out.println("there is a Exception has happened");
		}
	}
}
