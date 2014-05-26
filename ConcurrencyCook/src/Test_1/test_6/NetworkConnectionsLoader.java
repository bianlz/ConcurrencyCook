package Test_1.test_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Beginning net connecting: %s\n",new Date());
		try{
			TimeUnit.SECONDS.sleep(6);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("net connecting has finished:%s\n",new Date());
		
	}

}
