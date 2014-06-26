package Test_7.test_7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
	private MyAbstractQueuedSynchronizer sync;
	public MyLock(){
		sync = new MyAbstractQueuedSynchronizer();
	}
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquire(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		sync.acquireInterruptibly(1);
	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		 try {
			 return sync.tryAcquireNanos(1, 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			return sync.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time,unit));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void unlock() {
		// TODO Auto-generated method stub
		this.sync.release(1);
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return this.sync.new ConditionObject();
	}

}
