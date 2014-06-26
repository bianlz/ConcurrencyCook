package Test_7.test_7;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String name;
	private MyLock lock;
	public Task(String name,MyLock lock){
		this.name = name;
		this.lock = lock;
	}
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();
		System.out.printf("Task: %s: Take the lock\n",name);
		try {
			TimeUnit.SECONDS.sleep(2);
		System.out.printf("Task: %s: Free the lock\n",name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
