package Test_5.test_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class DocumentTask extends RecursiveTask<Integer> {
	private static final Long serialVersionUID = 1L;
	private String document[][];
	private int start,end;
	private String word;
	public DocumentTask(String document[][],int start,int end,String word){
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	protected Integer compute() {
		// TODO Auto-generated method stub
		int result = 0;
		if(end-start<10){
			result = this.processInLine(document, start, end, word);
		}else{
			int middle = (start+end)/2;
			DocumentTask task1 = new DocumentTask(document, start, middle, word);
			DocumentTask task2 = new DocumentTask(document, middle, end, word);
			this.invokeAll(task1,task2);
			try {
				result = task1.get() + task2.get();
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
	
	private int processInLine(String[][] document, int start, int end,String word){
		List<LineTask> tasks = new ArrayList<LineTask>();
		int result = 0;
		for(int i=start;i<end;i++){
			LineTask task = new LineTask(document[i], 0, document[i].length, word);
			tasks.add(task);
		}
		this.invokeAll(tasks);
		for(int i=0;i<tasks.size();i++){
			try {
				result +=tasks.get(i).get();
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

}
