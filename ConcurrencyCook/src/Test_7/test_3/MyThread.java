package Test_7.test_3;

import java.util.Date;

public class MyThread extends Thread {
	private Date creationDate;
	private Date startDate;
	private Date finishDate;
	public MyThread(Runnable r,String s){
		super(r, s);
		this.setCreationDate();
	}
	public void setCreationDate(){
		this.creationDate = new Date();
	}
	public void setStartDate(){
		this.startDate = new Date();
	}
	public void setFinishDate(){
		this.finishDate = new Date();
	}
	public long getExecutionTime(){
		return this.finishDate.getTime() - this.startDate.getTime();
	}
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append(this.getName());
		str.append(" : ");
		str.append(" creation Date: ");
		str.append(this.creationDate);
		str.append(" :running time :");
		str.append(this.getExecutionTime());
		str.append(" Milliseconds.");
		return str.toString();
	}
	public void run() {
		// TODO Auto-generated method stub
		this.setStartDate();
		super.run();
		this.setFinishDate();
	}
}
