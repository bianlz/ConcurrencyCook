package Test_7.test_3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		MyTask task = new MyTask();
		Thread thread = factory.newThread(task);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: Thread information.\n");
		System.out.printf("%s\n",thread);
		System.out.printf("Main: End of the example.\n");

	}

}
