package Test_4.test_9;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
		CompletionService<String> service = new ExecutorCompletionService<String>(executor);
		ReportRequest faceRequest = new ReportRequest("Face", service);
		ReportRequest onlineRequest = new ReportRequest("Online", service);
		ReportProcessor processor = new ReportProcessor(service);
		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);
		Thread senderThread =new Thread(processor);
		System.out.printf("Main :start the threads \n");
		faceThread.start();
		onlineThread.start();
		senderThread.start();
		try{
			System.out.printf("Main: waiting for the report generators . \n");
			onlineThread.join();
			faceThread.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Main :s shutting down the executor. \n");
		executor.shutdown();	
		try{
			executor.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		processor.setEnd(true);
		System.out.printf("Main :Ends ");
	}
}
