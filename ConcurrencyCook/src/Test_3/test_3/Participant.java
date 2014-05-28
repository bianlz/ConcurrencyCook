package Test_3.test_3;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
	private Videoconference videoconference;
	private String name;
	public Participant(String name,Videoconference videoconference){
		this.name = name ;
		this.videoconference = videoconference;
	}
	public void run() {
		// TODO Auto-generated method stub
		long duration = (long)(Math.random()*10);
		try{
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
			videoconference.arrive(name);
	}

}
