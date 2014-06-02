package Test_5.test_1;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> list = generator.generator(10000);
		Task task = new Task(0,list.size(),list,0.2);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		do{
			System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
			System.out.printf("Main: Thread Steal: %d\n",pool.getStealCount());
			System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
			try{
				TimeUnit.SECONDS.sleep(5);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}while(!task.isDone());
		pool.shutdown();
		if(task.isCompletedAbnormally()){
			System.out.printf("Main: The process has completed normally.\n");
		}
		for(Product product:list){
			if(product.getPrice()!=12){
				System.out.printf("Product %s: %f\n",product.getName(),product.getPrice());
			}
		}
		System.out.println("Main: End of the program.\n");
	}
}
