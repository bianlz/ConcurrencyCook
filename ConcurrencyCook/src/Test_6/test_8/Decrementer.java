package Test_6.test_8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable {
	private AtomicIntegerArray vector;
	public Decrementer(AtomicIntegerArray vector){
		this.vector = vector;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<vector.length();i++){
			this.vector.getAndDecrement(i);
		}
	}

}
