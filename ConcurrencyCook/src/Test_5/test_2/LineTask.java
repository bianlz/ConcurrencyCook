package Test_5.test_2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class LineTask extends RecursiveTask<Integer> {
	private static final Long serialVersionUID = 1L;
	private String line[];
	private int start;
	private int end;
	private String word;
	public LineTask(String line[],int start,int end,String word){
		this.start = start;
		this.end = end;
		this.line = line;
		this.word = word;
	}
	protected Integer compute() {
		// TODO Auto-generated method stub
		int result = 0;
		if(start-end<100){
			result = this.count( start, end);
		}else{
			int middle = (start-end)/2;
			LineTask t1 =new LineTask(line,start,middle+1,word);
			LineTask t2 =new LineTask(line,middle+1,end,word);
			this.invokeAll(t1,t2);
			try {
				result = this.groupResult(t1.get(),t2.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	private int count(int start,int end){
		int counter = 0;
		for(int i=start;i<end;i++){
			if(line[i].equals(word)){
				counter++;
			}
		}
		return counter;
	}
	private int groupResult(int r1,int r2){
		return r1+r2;
	}
}
