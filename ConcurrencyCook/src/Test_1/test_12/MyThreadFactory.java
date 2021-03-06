package Test_1.test_12;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	private String name;
	private List<String> stats;
	private int counter = 0;
	public MyThreadFactory(String name){
		this.name = name;
		stats = new ArrayList<String>();
		counter ++;
	}
	@Override
	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub
		Thread t=new Thread(arg0,name+"-Thread_"+counter);
		counter++;
		stats.add(String.format("created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
		return t;
	}
	public String getStats(){
		StringBuffer buffer=new StringBuffer();
		Iterator<String> it=stats.iterator();
		while (it.hasNext()) {
		buffer.append(it.next());
		buffer.append("\n");
		}
		return buffer.toString();
	}

}
