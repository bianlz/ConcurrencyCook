package Test_7.test_9;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingCounter counter = new ParkingCounter(5);
		Sensor1 sensor1 = new Sensor1(counter);
		Sensor2 sensor2 = new Sensor2(counter);
		Thread thread1 = new Thread(sensor1);
		Thread thread2 = new Thread(sensor2);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: Number of cars: %d\n",counter.get());
		System.out.printf("Main: End of the program.\n");
	}

}
