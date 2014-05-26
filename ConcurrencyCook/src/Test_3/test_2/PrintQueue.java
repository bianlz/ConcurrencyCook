package Test_3.test_2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	public boolean freePrints[];
	private Semaphore semaphore ;
	private Lock lock ;
	public PrintQueue(){
		this.semaphore = new Semaphore(3);
		freePrints = new boolean[3];
		lock = new ReentrantLock();
		for(int i =0;i<freePrints.length;i++){
			freePrints[i] = true;
		}
	}
	
	public void printJob(Object document){
		try{
			semaphore.acquire();
			Long duration=(long)(Math.random()*10);
			int assignedPrinter = this.getPrint();
			System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",Thread.currentThread().getName(), assignedPrinter,duration);
			Thread.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
	
	public int getPrint(){
		int ret = -1;
		try{
			lock.lock();
			for(int i =0;i<freePrints.length;i++){
				if(freePrints[i]){
					ret = i;
					freePrints[i] = false;
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
		return ret;
	}
}
