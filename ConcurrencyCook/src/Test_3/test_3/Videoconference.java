package Test_3.test_3;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private CountDownLatch controller;
	public Videoconference(int number){
		this.controller = new CountDownLatch(number);
	}
	public void arrive(String name){
		System.out.printf("%s has arrived \n", name);
		controller.countDown();
		System.out.printf("Videoconference : waiting for %d participants \n", controller.getCount());
	}
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.printf("VideoConference: Initialization: %d participants. \n",controller.getCount());
			this.controller.await();
			System.out.printf("VideoConference: All the participants have come \n");
			System.out.printf("VideoConference: Let's start... \n");

		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
	}

}
