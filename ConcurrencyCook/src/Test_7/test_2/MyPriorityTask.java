package Test_7.test_2;

import java.util.concurrent.TimeUnit;

public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
	private String name;
	private int priority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public MyPriorityTask(String name,int priority){
		this.name = name;
		this.priority = priority;
	}
	public int compareTo(MyPriorityTask o) {
		// TODO Auto-generated method stub
		if(this.priority>o.getPriority()){
			return -1;
		}else if(this.priority<o.getPriority()){
			return 1;
		}
		return 0;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("MyPriority : %s priority : %d \n",name,priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
