package Test_3.test_3;

public class Main {
	public static void main(String args[]){
		Videoconference videoconference = new Videoconference(10);
		Thread videoconThread = new Thread(videoconference);
		videoconThread.start();
		for(int i=0;i<10;i++){
			Participant pp = new Participant("participant"+i, videoconference);
			Thread ppThread = new Thread(pp);
			ppThread.start();
		}
	}
}
