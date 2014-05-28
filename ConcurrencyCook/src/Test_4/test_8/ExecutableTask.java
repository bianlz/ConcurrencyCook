package Test_4.test_8;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class ExecutableTask implements Callable<String> {
	public String name;
	public ExecutableTask(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try{
			Long duration = (long)(Math.random()*10);
			System.out.printf("%s: Waiting %d seconds for results.\n",this.name,duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		return "Hello ,"+name;
	}
	
}
