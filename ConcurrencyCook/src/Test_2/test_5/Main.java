package Test_2.test_5;

public class Main {
	public static void main(String args[]){
		PricesInfo pricesInfo = new PricesInfo();
		Thread threads = null;
		for(int i=0 ;i<3 ;i++){
			threads = new Thread(new Reader(pricesInfo));
			threads.start();
		}
		Writer writer = new Writer(pricesInfo);
		Thread writeThread = new Thread(writer);
		writeThread.start();
	}
}
