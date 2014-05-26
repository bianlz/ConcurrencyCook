package Test_1.test_9;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		SafeTask st = new SafeTask();
		for(int i=0;i<10;i++){
			Thread t = new Thread(st);
			t.start();
			try { 
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
