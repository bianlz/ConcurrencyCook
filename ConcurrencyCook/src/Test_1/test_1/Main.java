package Test_1.test_1;

public class Main {
	public static void main(String args[]){
		for(int i=0;i<10;i++){
			Calculator c = new Calculator(i); 
			Thread t = new Thread(c);
			t.start();
		}
	}
}
