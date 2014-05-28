package Test_1.test_12;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
