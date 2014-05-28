package Test_4.test_2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private Date initDate;
	private String name;
	public Task(String name){
		this.initDate = new Date();
		this.name = name;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Task %s: Created on: %s\n",Thread.currentThread().getName(),name,initDate);
		System.out.printf("%s: Task %s: start on: %s\n",Thread.currentThread().getName(),name,new Date());
		Long duration = (long)(Math.random()*10);
		System.out.printf("%s: Task %s: Doing a task during %dseconds\n",Thread.currentThread().getName(),name,duration);
		try{
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name,new Date());
	}
}
