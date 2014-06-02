package Test_5.test_1;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private int first;
	private int last;
	private double increment;
	public Task(int first,int last,List<Product> products,double increment){
		this.first = first;
		this.last = last;
		this.increment = increment;
		this.products = products;
	}
	protected void compute() {
		// TODO Auto-generated method stub
		if(last-first<10){
			this.updatePrice();
		}else{
			int middle = (last+first)/2;
			System.out.printf("Task: Pending tasks:%s\n",getQueuedTaskCount());
			Task t1 = new Task(first,middle+1,products,increment);
			Task t2 = new Task(middle+1,last,products,increment);
			this.invokeAll(t1,t2);
		}
	}
	private void updatePrice(){
		for(int i=first;i<last;i++){
			Product product = products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
		}
	}

}
