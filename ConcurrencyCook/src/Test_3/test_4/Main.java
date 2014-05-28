package Test_3.test_4;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String args[]){
		final int ROWS=10000;
		final int NUMBERS=1000;
		final int SEARCH=5;
		final int PARTICIPANTS=5;
		final int LINES_PARTICIPANT=2000;
		MatrixMock matrixMock = new MatrixMock(ROWS,NUMBERS,SEARCH);
		Result result = new Result(ROWS);
		Grouper group = new Grouper(result);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,group);
		Searcher[] searchers = new Searcher[PARTICIPANTS];
		for(int i=0;i<searchers.length;i++){
			searchers[i]=new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT, matrixMock, result, 5,barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		System.out.printf("Main: The main thread has finished.\n");
	}
}
