package Test_3.test_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String args[]){
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		List<String> buffer1 = new  ArrayList<String>();
		List<String> buffer2 = new  ArrayList<String>();
		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		Thread proThread = new Thread(producer);
		Thread conThread = new Thread(consumer);
		proThread.start();
		conThread.start();
	}
}
