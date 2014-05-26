package Test_3.test_4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
	private int firstRow;
	private int lastRow;
	private MatrixMock matrixMock;
	private Result result;
	private int number;
	private final CyclicBarrier barrier;
	public Searcher(int firstRow,int lastRow,MatrixMock matrixMock,Result result,int number,CyclicBarrier cyclicBarrier){
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.matrixMock = matrixMock;
		this.result = result;
		this.number = number;
		this.barrier = cyclicBarrier;
	}
	public void run() {
		// TODO Auto-generated method stub
		int counter;
		System.out.printf("%s: Processing lines from %d to %d.\n",Thread.currentThread().getName(),firstRow,lastRow);
		for(int i=firstRow;i<lastRow;i++){
			int[] row = this.matrixMock.getRow(i);
			counter = 0;
			for(int j=0;j<row.length;j++){
				if(row[j]==number){
					counter++;
				}
			}
			result.setData(i, counter);
		}
		System.out.printf("%s: Lines processed.\n",Thread. currentThread().getName());
		try{
			this.barrier.await();
		}catch(BrokenBarrierException ex){
			ex.printStackTrace();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}

}
