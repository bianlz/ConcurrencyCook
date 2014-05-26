package Test_2.test_6;

public class Main {
	public static void main(String args[]){
		FileMock fileMock = new FileMock(100,10);
		Buffer buffer = new Buffer(10);
		Producer producer = new Producer(fileMock,buffer);
		Thread producerThread = new Thread(producer);
		producerThread.start();
		for(int i=0;i<3;i++){
			(new Thread(new Consumer(buffer))).start();;
		}
	}
}
