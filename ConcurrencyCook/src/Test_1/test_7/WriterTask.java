package Test_1.test_7;


import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;


public class WriterTask implements Runnable {
	private Deque<Event> deque;
	public WriterTask(Deque<Event> deque){
		this.deque = deque;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ;i<100;i++){
			Event e = new Event();
			e.setDate(new Date());
			e.setEvent(String.format("The thread %s has generated an   event",Thread.currentThread().getId()));
			this.deque.addFirst(e);
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}

}
