package Test_4.test_10;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.printf("RejectedTaskController: The task %s has been rejected \n",r.toString());
		System.out.printf("RejectedTaskController: RejectedTaskController:%s \n",executor.toString());
		System.out.printf("RejectedTaskController:Terminating:%s \n",executor.isTerminating());
		System.out.printf("RejectedTaskController:terminated:%s\n",executor.isTerminated());
	}

}
