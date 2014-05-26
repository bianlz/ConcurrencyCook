package Test_3.test_4;

public class Grouper implements Runnable {
	private Result result;
	public Grouper(Result result){
		this.result = result;
	}
	public void run() {
		// TODO Auto-generated method stub
		int finalResult = 0;
		int[] data = result.getData();
		for(int i=0;i<data.length;i++){
			finalResult += data[i];
		}
		System.out.printf("Grouper: Total result: %d.\n",finalResult);
	}

}
