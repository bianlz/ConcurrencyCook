package Test_2.test_3;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
	private int maxSize;
	private LinkedList<Date> storage;
	public EventStorage(){
		maxSize = 20;
		storage = new LinkedList<Date>();
	}
	public synchronized void set(){
		while(storage.size() == maxSize){
			try{
				wait();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		storage.offer(new Date());
		System.out.printf("Set: %d \n",storage.size());
		notifyAll();
	}
	public synchronized void get(){
		while(storage.size() == 0){
			try{
				wait();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s \n",storage.size(),((LinkedList<?>)storage).poll());
		notifyAll();
	}
}
