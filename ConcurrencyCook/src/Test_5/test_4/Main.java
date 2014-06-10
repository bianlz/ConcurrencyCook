package Test_5.test_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[100];
		Task task = new Task(array,0,100);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(task.isCompletedAbnormally()){
			System.out.printf("Main: An Exception has accured \n");
			System.out.printf("Main: %s \n",task.getException());
		}
		System.out.printf("Main: Result :%d",task.join());
	}

}
