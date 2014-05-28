package Test_4.test_7;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {

	public String call() throws Exception {
		// TODO Auto-generated method stub
		while(true){
			try{
				System.out.printf("Task: Test\n");
				Thread.sleep(100);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}

}
