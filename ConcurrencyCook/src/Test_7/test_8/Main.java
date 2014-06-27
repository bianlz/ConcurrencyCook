package Test_7.test_8;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<Event>();
		Thread[] producers = new Thread[10];
		for(int i=0;i<producers.length;i++){
			Producer producer = new Producer(buffer);
			producers[i] = new Thread(producer);
			producers[i].start();
		}
		Consumer consumer = new Consumer(buffer);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		System.out.printf("Main: Buffer: Consumer count: %d\n",buffer. getWaitingConsumerCount());
		Event event = new Event("core Event", 0);
		try {
			buffer.transfer(event);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: My Event has ben transfered.\n");
		for(int i=0;i<producers.length;i++){
			try {
				producers[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: Buffer: Consumer count: %d\n",buffer. getWaitingConsumerCount());
		event = new Event("core event 2", 0);
		try {
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program\n");
	}
}
