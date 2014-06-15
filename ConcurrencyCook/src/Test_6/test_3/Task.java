package Test_6.test_3;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {
	private int id;
	private PriorityBlockingQueue<Event> queue;
	public Task(int id,PriorityBlockingQueue<Event> queue){
		this.id = id;
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			Event event = new Event(id, i);
			queue.add(event);
		}
	}

}
