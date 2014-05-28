package Test_1.test_9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	private ThreadLocal<Date> tl = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),tl.get());
		try {
			  TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),tl.get());
	}

}
