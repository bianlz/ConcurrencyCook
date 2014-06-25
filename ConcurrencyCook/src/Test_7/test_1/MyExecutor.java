package Test_7.test_1;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor extends ThreadPoolExecutor {
	private ConcurrentHashMap<String, Date> startTimes;
	public MyExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		startTimes=new ConcurrentHashMap<String, Date>();
		// TODO Auto-generated constructor stub
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		System.out.printf("MyExecutor: Going to shutdown.\n");
		System.out.printf("MyExecutor: Executed tasks:%d\n",getCompletedTaskCount());
		System.out.printf("MyExecutor: Running tasks:%d\n",getActiveCount());
		System.out.printf("MyExecutor: Pending tasks:%d\n",getQueue().size());
		super.shutdown();
	}

	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		System.out.printf("MyExecutor: Going to immediately shutdown.\n");
		System.out.printf("MyExecutor: Executed tasks:%d\n",getCompletedTaskCount());
		System.out.printf("MyExecutor: Running tasks:%d\n",getActiveCount());
		System.out.printf("MyExecutor: Pending tasks:%d\n",getQueue().size());
		return super.shutdownNow();
	}

	protected void beforeExecute(Thread t, Runnable r) {
		// TODO Auto-generated method stub
		System.out.printf("MyExecutor: A task is beginning: %s :%s\n",t.getName(),r.hashCode());
		startTimes.put(String.valueOf(r.hashCode()), new Date());
	}

	protected void afterExecute(Runnable r, Throwable t) {
		// TODO Auto-generated method stub
		Future<?> result=(Future<?>)r;
		try {
			System.out.printf("*********************************\n");
			System.out.printf("MyExecutor: A task is finishing.\n");
			System.out.printf("MyExecutor: Result: %s\n",result.get());
			Date startDate=startTimes.remove(String.valueOf(r.hashCode()));
			Date finishDate=new Date();
			long diff=finishDate.getTime()-startDate.getTime();
			System.out.printf("MyExecutor: Duration: %d\n",diff);
			System.out.printf("*********************************\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch(ExecutionException e){
			e.printStackTrace();
		}
		
	}
	
}
