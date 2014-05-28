package Test_3.test_5;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {
	public List<String> buffer;
	public Exchanger<List<String>> exchanger;
	public Consumer(List<String> buffer,Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	public void run() {
		// TODO Auto-generated method stub
		int cycle = 0;
		for(int i=0;i<10;i++){
			System.out.printf("Consumer: Cycle %d\n", cycle);
			try{
				this.buffer = this.exchanger.exchange(buffer);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			for(int j=0;j<10;j++){
				System.out.println("Consumer: " + buffer.get(0));
				buffer.remove(0);
			}
			cycle++;
		}
	}

}
