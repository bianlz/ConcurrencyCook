package Test_7.test_9;

public class Sensor1 implements Runnable {
	private ParkingCounter counter;
	public Sensor1(ParkingCounter counter){
		this.counter = counter;
	}
	public void run() {
		// TODO Auto-generated method stub
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	}

}
