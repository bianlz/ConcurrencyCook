package Test_7.test_7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {

	/**  
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）  
	 *  
	 * @since 1.0.0  
	 */  
	
	private static final long serialVersionUID = 1L;
	private AtomicInteger state;
	public MyAbstractQueuedSynchronizer(){
		this.state = new AtomicInteger(0);
	}
	protected boolean tryAcquire(int arg) {
		// TODO Auto-generated method stub
		return state.compareAndSet(0, 1);
	}
	protected boolean tryRelease(int arg) {
		// TODO Auto-generated method stub
		return state.compareAndSet(1, 0);
	}
	

}
