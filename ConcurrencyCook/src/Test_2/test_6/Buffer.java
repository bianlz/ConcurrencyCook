package Test_2.test_6;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	public int maxSize;
	public LinkedList<String> buffer;
	public ReentrantLock lock;
	public Condition lines;
	public Condition spaces;
	public boolean pendingLines;
	public Buffer(int maxSize){
		this.maxSize = maxSize;
		lock = new ReentrantLock();
		lines = lock.newCondition();
		spaces = lock.newCondition();
		pendingLines = true;
		buffer = new LinkedList<String>();
	}
	
	public void insert(String line){
		lock.lock();
		try{
			while(buffer.size()==maxSize){
				lines.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(),buffer.size());
			lines.signalAll();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public String get(){
		String line = null;
		lock.lock();
		try{
			while((buffer.size()==0)&&this.hasPendingLines()){
				spaces.await();
			}
			if(this.hasPendingLines()){
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n",Thread.currentThread().getName(),buffer.size());
				spaces.signalAll();
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
		return line;
	}
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines=pendingLines;
	}

	
	public boolean hasPendingLines(){
		return pendingLines||buffer.size()>0;
	}
}
