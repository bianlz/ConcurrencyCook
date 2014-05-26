package Test_2.test_4;

public class Main {
	public static void main(String args[]){
		PrintQueue printQueue = new PrintQueue();
		Thread[] threads = new Thread[10];
		for(int i=0;i<10;i++){
			threads[i] = new Thread(new Job(printQueue));
		}
		
		for(Thread thread:threads){
			thread.start();
		}
	}
}
