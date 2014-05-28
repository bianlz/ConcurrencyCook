package Test_3.test_1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private Semaphore semaphore ;
	public PrintQueue(){
		this.semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document){
		try{
			semaphore.acquire();
			Long duration=(long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+ ":PrintQueue: Printing a Job during "+(duration/1000)+" seconds");
			Thread.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
}
