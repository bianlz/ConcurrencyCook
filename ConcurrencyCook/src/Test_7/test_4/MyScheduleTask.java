package Test_7.test_4;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduleTask<V> extends FutureTask<V> implements
		RunnableScheduledFuture<V> {
	private RunnableScheduledFuture<V> task;
	private long startDate;
	private ScheduledThreadPoolExecutor executor;
	private long period;
	
	public MyScheduleTask(Runnable runnable,V result,RunnableScheduledFuture<V> task,ScheduledThreadPoolExecutor executor) {
		super(runnable, result);
		// TODO Auto-generated constructor stub
		this.task=task;
		this.executor=executor;
	}
	
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		if(!this.isPeriodic()){
			return task.getDelay(unit);
		}else{
			if(startDate==0){
				return task.getDelay(unit);
			}
			Date date = new Date();
			return unit.convert(date.getTime() - startDate, TimeUnit.MILLISECONDS);
		}
		
	}

	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return task.compareTo(o);
	}

	public boolean isPeriodic() {
		// TODO Auto-generated method stub
		return task.isPeriodic();
	}

	public void run() {
		// TODO Auto-generated method stub
		if(isPeriodic()&&(!executor.isShutdown())){
			Date date = new Date();
			startDate = date.getTime() +this.period;
			executor.getQueue().add(this);
		}
		System.out.printf("Pre-MyScheduledTask: %s\n",new Date());
		System.out.printf("MyScheduledTask: Is Periodic:%s\n",isPeriodic());
		super.runAndReset();
		System.out.printf("Post-MyScheduledTask: %s\n",new Date());
	}
	public void setPeriod(long period) {
		this.period=period;
	}


}
