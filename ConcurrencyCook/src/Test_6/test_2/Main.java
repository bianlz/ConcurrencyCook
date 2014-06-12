package Test_6.test_2;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>();
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		for(int i=0;i<5;i++){
			for(int j=0;j<3;j++){
				try {
					String req =  list.take();
					System.out.printf("Main :Req: %s at %s / size: %d \n",req,new Date(),list.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Main: End of the program . \n");
	}

}
