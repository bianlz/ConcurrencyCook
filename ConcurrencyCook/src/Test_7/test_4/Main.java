package Test_7.test_4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
		Task task = new Task();
		System.out.printf("Main: %s\n",new Date());
		executor.schedule(task, 1, TimeUnit.SECONDS);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task = new Task();
		System.out.printf("Main: %s\n",new Date());
		executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program.\n");

	}
}
