package Test_1.test_6;

import java.util.Date;

public class Main {
	public static void main(String args[]){
		DataSourceLoader dsl = new DataSourceLoader();
		NetworkConnectionsLoader ncl = new NetworkConnectionsLoader();
		Thread t1 = new Thread(dsl);
		Thread t2 = new Thread(ncl);
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
	}
}
