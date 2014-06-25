package Test_7.test_4;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Task: Begin.\n");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Task: End.\n");
	}

}
