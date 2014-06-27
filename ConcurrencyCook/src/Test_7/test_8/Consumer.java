package Test_7.test_8;

public class Consumer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	public Consumer(MyPriorityTransferQueue<Event> buffer){
		this.buffer = buffer;
	}
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<1002; i++) {
			try {
				Event event = buffer.take();
				System.out.printf("Consumer: %s: %d\n",event. getThread(),event.getPriority());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

}
