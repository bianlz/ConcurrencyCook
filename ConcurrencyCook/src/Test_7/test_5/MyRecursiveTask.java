package Test_7.test_5;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	private int start,end;
	int array[] ;
	public MyRecursiveTask(int start,int end,int array[]){
		this.start = start;
		this.end = end;
		this.array = array;
	}
	protected Integer compute() {
		MyWorkerThread thread = (MyWorkerThread)Thread.currentThread();
		thread.addTask();
		return null;
	}

}
