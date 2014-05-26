package Test_1.test_7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String args[]){
		Deque<Event> deque = new ArrayDeque<Event>();
		WriterTask wt = new WriterTask(deque);
		for(int i=0;i<3;i++){
			Thread t = new Thread(wt);
			t.start();
		}
		CleanerTask ct = new CleanerTask(deque);
		ct.start();
	}
}
