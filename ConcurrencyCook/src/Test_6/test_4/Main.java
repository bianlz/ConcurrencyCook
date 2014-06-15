package Test_6.test_4;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DelayQueue<Event> queue = new DelayQueue<Event>();
		Thread threads[] = new Thread[5];
		for(int i =0;i<threads.length;i++){
			Task task = new Task(i+1,queue);
			threads[i] =new Thread(task);
		}
		for(int i =0;i<threads.length;i++){
			threads[i].start();
		}
		for(int i =0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		do{
			int count = 0;
			Event event ;
			do{
				event = queue.poll();
				if(null!=event){
					count++;
				}
			}while(event!=null);
			System.out.printf("At %s you have read %d events \n",new Date(),count);
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(queue.size()>0);
	}

}
