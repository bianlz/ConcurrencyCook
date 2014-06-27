package Test_7.test_8;

public class Event implements Comparable<Event> {
	private String thread;
	private int priority;
	public Event(String thread,int priority){
		this.thread = thread;
		this.priority = priority;
	}
	
	public String getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}

	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		if(this.getPriority()<o.getPriority()){
			return 1;
		}else if(this.getPriority()>o.getPriority()){
			return -1;
		}
		return 0;
	}

}
