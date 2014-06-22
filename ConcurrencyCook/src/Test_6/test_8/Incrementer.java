package Test_6.test_8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable {
	private AtomicIntegerArray vector;
	public Incrementer(AtomicIntegerArray vector){
		this.vector = vector;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<this.vector.length();i++){
			this.vector.getAndIncrement(i);
		}
	}

}
