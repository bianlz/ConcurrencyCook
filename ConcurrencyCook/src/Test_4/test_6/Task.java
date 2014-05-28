package Test_4.test_6;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {
	private String name;
	public Task(String name){
		this.name = name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Starting at : %s\n",name,new Date());
	}

}
