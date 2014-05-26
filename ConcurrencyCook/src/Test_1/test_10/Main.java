package Test_1.test_10;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		ThreadGroup threadGroup= new ThreadGroup("Group1");
		Result result = new Result();
		SearchTask task = new SearchTask(result);
		for(int i=0;i<5;i++){
			Thread thread = new Thread(threadGroup,task);
			thread.start();
		}
		try{
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e) {

		}
		threadGroup.list();
		System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
		Thread[] threads=new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i=0; i<threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}
	private static void waitFinish(ThreadGroup threadGroup){
		while(threadGroup.activeCount()>9){
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
}
