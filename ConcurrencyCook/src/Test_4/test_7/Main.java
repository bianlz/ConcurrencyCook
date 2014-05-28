package Test_4.test_7;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		Task task = new Task();
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		System.out.printf("Main: Executing the Task\n");
		Future<String> result = executor.submit(task);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.cancel(true);
		System.out.printf("Main: Canceling the Task\n");
		
		System.out.printf("Main: Canceled: %s\n",result.isCancelled());
		System.out.printf("Main: Done: %s\n",result.isDone());
		executor.shutdown();
		System.out.printf("Main: The executor has finished\n");
	}
}
