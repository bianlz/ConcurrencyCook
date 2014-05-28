package Test_4.test_8;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
	private String name;
	public ResultTask(Callable<String> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.name = ((ExecutableTask)(arg0)).getName();
	}
	protected void done() {
		// TODO Auto-generated method stub
		
		if(this.isCancelled()){
			System.out.printf("%s: Has been canceled\n",name);
		}else{
			System.out.printf("%s: Has finished\n",name);
		}
	}
	
}
