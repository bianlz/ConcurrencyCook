package Test_3.test_5;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;
	public Producer(List<String> buffer,Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	public void run() {
		// TODO Auto-generated method stub
		int cycle = 0;
		for(int i=0;i<10;i++){
			System.out.printf("Producer: Cycle %d\n", cycle);
			for(int j=0;j<10;j++){
				String message = "Event " + ((i * 10) + j);
				System.out.printf("Producer: %s\n", message);
				buffer.add(message);
			}
			try{
				this.buffer = this.exchanger.exchange(buffer);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			System.out.println("Producer: " + buffer.size());
			cycle++;
		}
	}

}
