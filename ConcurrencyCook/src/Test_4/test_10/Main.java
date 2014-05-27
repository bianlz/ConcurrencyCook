package Test_4.test_10;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		RejectedTaskController controller = new RejectedTaskController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.printf("Main: starting \n");
		for(int i=0 ;i<3;i++){
			Task task = new Task("Task" + i);
			executor.submit(task);
		}
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Main: shutting down the executor \n");
		executor.shutdown();
		System.out.printf("Main :sending another task .\n");
		Task task = new Task("RejectedTask");
		executor.submit(task);
		System.out.printf("Main: End\n");
	}
}
