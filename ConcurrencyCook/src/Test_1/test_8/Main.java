package Test_1.test_8;

public class Main {
	public static void main(String args[]){
		Task task = new Task();
		Thread t = new Thread(task);
		t.setUncaughtExceptionHandler(new ExceptionHandler());
		t.start();
	}
}
