package Test_6.test_3;

public class Event implements Comparable<Event> {
	private int thread;
	private int priority;
	
	public int getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}
	public Event(int thread,int priority){
		this.thread = thread;
		this.priority = priority;
	}
	@Override
	public int compareTo(Event arg0) {
		// TODO Auto-generated method stub
		if(this.priority>arg0.getPriority()){
			return -1;
		}else if(this.priority<arg0.getPriority()){
			return 1;
		}
		return 0;
	}
}
