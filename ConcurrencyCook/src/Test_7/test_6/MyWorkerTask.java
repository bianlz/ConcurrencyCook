package Test_7.test_6;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;

public abstract class MyWorkerTask extends ForkJoinTask<Void> {
	private String name;
	public MyWorkerTask(String name){
		this.name = name;
	}
	public Void getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void setRawResult(Void value) {
		// TODO Auto-generated method stub

	}

	protected boolean exec() {
		// TODO Auto-generated method stub
		Date start = new Date();
		this.compute();
		Date finish = new Date();
		Long diff = start.getTime() - finish.getTime();
		System.out.printf("MyWorkerTask: %s : %d Milliseconds to complete.\n",name,diff);
		return true;
	}
	
	public abstract void compute();

}
