package Test_7.test_3;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	private String prefix;
	private int counter;
	public MyThreadFactory(String prefix){
		this.prefix = prefix;
		counter=1;
	}
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		MyThread thread = new MyThread(r, prefix +"-"+ counter);
		counter++;
		return thread;
	}

}
