package Test_7.test_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyExecutor myExecutor = new MyExecutor(2, 4, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>());
		List<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0;i<10;i++){
			SleepTwoSecondsTask task = new SleepTwoSecondsTask();
			Future<String> f = myExecutor.submit(task);
			results.add(f);
		}
		for (int i=0; i<5; i++){
			try {
			String result=results.get(i).get();
			System.out.printf("Main: Result for Task %d :%s\n",i,result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}
		}
		myExecutor.shutdown();
		for (int i=5; i<10; i++){
			try {
			String result=results.get(i).get();
			System.out.printf("Main: Result for Task %d :%s\n",i,result);
			} catch (InterruptedException  e) {
				e.printStackTrace();
			} catch (ExecutionException e){
				e.printStackTrace();
			}
		}
	}

}
