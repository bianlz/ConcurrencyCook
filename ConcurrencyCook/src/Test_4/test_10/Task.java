package Test_4.test_10;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String name;
	public Task(String name){
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Task "+name +": Starting");
		try{
			long duration = (long)(Math.random()*10);
			System.out.printf("Task %s :ReportGenerator: generating a report during %d seconds \n",name,duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Task %s :Ending \n",name);
	}
	public String toString(){
		return name;
	}
}
