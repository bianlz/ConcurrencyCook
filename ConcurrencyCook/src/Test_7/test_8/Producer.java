package Test_7.test_8;

public class Producer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	public Producer(MyPriorityTransferQueue<Event> buffer){
		this.buffer = buffer;
	}
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			Event event = new Event(Thread.currentThread().getName()+i, i);
			buffer.add(event);
		}
	}

}
