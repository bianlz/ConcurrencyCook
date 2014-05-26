package Test_1.test_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Beginning data sources loading: %s\n",new Date());
		try{
			TimeUnit.SECONDS.sleep(4);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Data sources loading has finished:%s\n",new Date());
	}

}
