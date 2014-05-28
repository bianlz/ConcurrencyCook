package Test_1.test_4;

public class Main {
	public static void main(String args[]){
		FileSearch fs = new FileSearch("/Users/bianlanzhou/Downloads/","bower.json");
		Thread t = new Thread(fs);
		t.start();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		t.interrupt();
	}
}
