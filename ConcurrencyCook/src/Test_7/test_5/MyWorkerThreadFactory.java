package Test_7.test_5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {

	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		// TODO Auto-generated method stub
		MyWorkerThread thread = new MyWorkerThread(pool);
		return thread;
	}

}
