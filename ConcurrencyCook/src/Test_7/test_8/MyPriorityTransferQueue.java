package Test_7.test_8;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements
		TransferQueue<E> {
	private LinkedBlockingDeque<E> transfered;
	private AtomicInteger counter;
	private ReentrantLock lock;
	public MyPriorityTransferQueue(){
		transfered = new LinkedBlockingDeque<E>();
		counter = new AtomicInteger(0);
		lock = new ReentrantLock();
	}
	public boolean tryTransfer(E e) {
		// TODO Auto-generated method stub
		lock.lock();
		boolean value;
		if(counter.get()==0){
			value = false;
		}else{
			put(e);
			value = true;
		}
		return value;
	}

	public void transfer(E e) throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
		}else{
			transfered.add(e);
			lock.unlock();
			synchronized (e) {
				e.wait();
			}
		}
	}

	public boolean tryTransfer(E e, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
			return true;
		}else{
			this.transfered.add(e);
			long out = TimeUnit.MILLISECONDS.convert(timeout, unit);
			lock.unlock();
			e.wait(out);
			lock.lock();
			if(this.transfered.contains(e)){
				transfered.remove(e);
				lock.unlock();
				return false;
			}else{
				lock.unlock();
				return true;
			}
		}
	}

	public boolean hasWaitingConsumer() {
		// TODO Auto-generated method stub
		return (counter.get()!=0);
	}

	public int getWaitingConsumerCount() {
		// TODO Auto-generated method stub
		return counter.get();
	}
	
	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		E value = this.transfered.poll();
		if(value==null){
			lock.unlock();
			value = super.take();
			lock.lock();
		}else{
			synchronized (value) {
				value.notify();
			}
		}
		counter.decrementAndGet();
		lock.unlock();
		return value;
	}
	
	

}
