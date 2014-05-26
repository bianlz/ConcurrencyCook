package Test_1.test_11;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.printf("The thread %s has thrown an Exception\n",t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}

	
}
