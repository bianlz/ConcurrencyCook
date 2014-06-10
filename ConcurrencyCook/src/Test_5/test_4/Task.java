package Test_5.test_4;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Task extends RecursiveTask<Integer> {
	private int start,end;
	private int array[];
	public Task(int array[],int start,int end){
		this.start = start;
		this.end = end;
		this.array = array;
	}
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		System.out.printf("Task: start from %d to %d \n" ,start,end);
		if(end-start<10){
			if((3>start)&&(3<end)){
				throw new RuntimeException("This task throws an Exception : task from "+start +" to " + end+"\n");
			}
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}else{
			int mid = (start+end)/2;
			Task task1 = new Task(array,start,mid);
			Task task2 = new Task(array,mid,end);
			this.invokeAll(task1,task2);
		}
		System.out.printf("Task: End from %d to %d \n",start,end);
		return 0;
	}

}
