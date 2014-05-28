package Test_4.test_2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import Test_4.test_2.Task;

public class Server {
	private ThreadPoolExecutor executor;
	public Server(){
		executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
	}
	public void executeTask(Task task){
		System.out.printf("Server: A new task has arrived\n");
		this.executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
	}
	public void endServer(){
		this.executor.shutdown();
	}
}
