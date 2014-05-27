package Test_4.test_9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {
	private String title;
	private String sender;
	public ReportGenerator(String sender,String title){
		this.title = title;
		this.sender = sender;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try{
			long duration = (long)(Math.random()*10);
			System.out.printf("%s_%s : ReportGenerator:Generating a report during %d seconds \n", this.sender,this.title,duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		return sender+":"+title;
	}

}
