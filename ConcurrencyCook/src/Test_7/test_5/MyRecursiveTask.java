package Test_7.test_5;

import java.util.concurrent.ExecutionException;
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
		Integer ret = 0;
		MyWorkerThread thread = (MyWorkerThread)Thread.currentThread();
		thread.addTask();
		if(end-start < 1000){
			ret = business(start,end);
		}else{
			int middle = (end+start)/2;
			MyRecursiveTask task1 = new MyRecursiveTask(start, middle, array);
			MyRecursiveTask task2 = new MyRecursiveTask(middle, end, array);
			this.invokeAll(task1,task2);
			try {
				ret = this.addResult(task1.get(),task2.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	public int business(int start,int end){
		//do something
		return end - start;
	}
	public int addResult(int arg1,int arg2){
		return arg1 + arg2;
	}
}
