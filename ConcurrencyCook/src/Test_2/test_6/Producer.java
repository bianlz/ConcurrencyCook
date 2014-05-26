package Test_2.test_6;

public class Producer implements Runnable {
	private FileMock fileMock;
	private Buffer buffer;
	public Producer(FileMock fileMock,Buffer buffer){
		this.fileMock = fileMock;
		this.buffer = buffer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		buffer.setPendingLines(true);
		while(fileMock.hasMoreLine()){
			buffer.insert(fileMock.getLine());
		}
		buffer.setPendingLines(false);
	}

}
