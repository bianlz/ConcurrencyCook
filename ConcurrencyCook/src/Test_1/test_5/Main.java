package Test_1.test_5;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		FileClock fc = new FileClock();
		Thread t = new Thread(fc);
		t.start();
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e){
			System.out.printf("The FileClock has been interrupted");
		}
		t.interrupt();
	}
}
