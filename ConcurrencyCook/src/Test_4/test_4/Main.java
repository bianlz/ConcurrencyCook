package Test_4.test_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
	public static void main(String args[]){
		String username = "test";
		String password = "test";
		UserValidator ladpValidator = new UserValidator("LADP");
		UserValidator dbValidator=new UserValidator("DataBase");
		TaskValidator ladpTask = new TaskValidator(username, password, ladpValidator);
		TaskValidator dbTask = new TaskValidator(username, password, dbValidator);
		List<TaskValidator> taskList = new ArrayList<TaskValidator>();
		taskList.add(ladpTask);
		taskList.add(dbTask);
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		String result = "";
		try {
			result = executor.invokeAny(taskList);
			System.out.printf("Main: Result: %s\n",result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Main: End of the Execution\n");
		executor.shutdown();
	}
}
