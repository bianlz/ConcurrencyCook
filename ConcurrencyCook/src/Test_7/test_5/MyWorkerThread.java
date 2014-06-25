package Test_7.test_5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThread extends ForkJoinWorkerThread {
	private static ThreadLocal<Integer> taskCounter= new ThreadLocal<Integer>();
	protected MyWorkerThread(ForkJoinPool pool) {
		super(pool);
		// TODO Auto-generated constructor stub
	}
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.printf("MyWorkerThread %d: Initializing taskcounter.\n",getId());
		this.taskCounter.set(0);
	}
	protected void onTermination(Throwable exception) {
		// TODO Auto-generated method stub
		super.onTermination(exception);
		System.out.printf("MyWorkerThread %d:%d\n",getId(),taskCounter.get());
	}
	public void addTask(){
		int counter = this.taskCounter.get().intValue();
		counter++;
		this.taskCounter.set(counter);
	}
	
}
