package Test_7.test_3;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
