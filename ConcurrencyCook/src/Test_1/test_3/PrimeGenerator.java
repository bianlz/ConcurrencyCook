package Test_1.test_3;

public class PrimeGenerator extends Thread {
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long number = 1L;
		while(true){
			if(this.isPrime(number)){
				System.out.printf("Number %d is prime \n", number);
			}
			if(this.isInterrupted()){
				System.out.printf("Thread has been interrrupted \n");
				return ;
			}
			number++;
		}
	}
	
	public boolean isPrime(long number){
		if(number<=2){
			return true;
		}
		for(long i=2;i<number;i++){
			if((number%i)==0){
				return false;
			}
		}
		return true;
	}

}
