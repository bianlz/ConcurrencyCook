package Test_2.test_3;

public class Consumer implements Runnable {
	private EventStorage eventStorage;
	public Consumer(EventStorage eventStorage){
		this.eventStorage = eventStorage;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<100; i++){
			eventStorage.get();
		}
	}

}
