package Test_6.test_8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread inThread[] = new Thread[THREADS];
		Thread deThread[] = new Thread[THREADS];
		for(int i=0;i<THREADS;i++){
			inThread[i] = new Thread(incrementer);
			deThread[i] = new Thread(decrementer);
			inThread[i].start();
			deThread[i].start();
		}
		for(int i=0;i<100;i++){
			try {
				inThread[i].join();
				deThread[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i =0;i<vector.length();i++){
			if(vector.get(i)!=0){
				System.out.println(" vector["+i+"] : "+vector.get(i));
			}
		}
		System.out.println("Main : end of example.");
	}

}
