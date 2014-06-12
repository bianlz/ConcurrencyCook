package Test_6.test_2;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
	private LinkedBlockingDeque<String> list;
	public Client(LinkedBlockingDeque<String> list){
		this.list = list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				StringBuilder request = new StringBuilder();
				request.append(i).append(":").append(j);
				list.push(request.toString());
				System.out.printf("Client: %s at %s . \n",request,new Date());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Client: End. \n");
	}

}
