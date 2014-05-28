package Test_4.test_6;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		System.out.printf("Main: Starting at: %s\n",new Date());
		ScheduledExecutorService executor = (ScheduledExecutorService)Executors.newScheduledThreadPool(1);
		Task task = new Task("task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1L, 2L, TimeUnit.SECONDS);
		for(int i=0;i<10;i++){
			System.out.printf("Main: Delay: %d\n",result.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Finished at: %s\n",new Date());
	}
}
