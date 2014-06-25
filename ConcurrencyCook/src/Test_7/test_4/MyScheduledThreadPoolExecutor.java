package Test_7.test_4;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

	public MyScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
		// TODO Auto-generated constructor stub
	}

	protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable,
			RunnableScheduledFuture<V> task) {
		// TODO Auto-generated method stub
		MyScheduleTask<V> myTask=new MyScheduleTask<V>(runnable, null, task,this);
		return myTask;
	}

	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
			long initialDelay, long period, TimeUnit unit) {
		// TODO Auto-generated method stub
		MyScheduleTask<?> myTask=(MyScheduleTask<?>)super.scheduleAtFixedRate(command, initialDelay, period, unit);
		myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period,unit));
		return myTask;
	}

}
