package Test_7.test_6;

public class Task extends MyWorkerTask {
	private int start;
	private int end;
	private int array[];
	public Task(String name,int start,int end,int array[]) {
		super(name);
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
		this.array = array;
	}

	public void compute() {
		// TODO Auto-generated method stub
		if(end-start>100){
			int middle = (start+end)/2;
			Task task1 = new Task(this.getName() +"1" ,start,middle,array);
			Task task2 = new Task(this.getName() +"2" ,middle,end,array);
			this.invokeAll(task1,task2);
		}else{
			for(int i=start;i<end;i++){
				array[i]++;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
