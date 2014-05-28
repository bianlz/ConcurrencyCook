package Test_1.test_2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Main {
	public static void main(String args[]){
		Thread[] threads = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		for(int i=0;i<10;i++){
			threads[i] = new Thread(new Calculator(i));
			if((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread_"+ i );
		}
			PrintWriter pw = null;
		try{
			FileWriter file = new FileWriter("/Users/bianlanzhou/Desktop/log.txt");
			pw = new PrintWriter(file);
			for(int i=0;i<10;i++){
				pw.println("Main : Status of Thread " +i+ ":" + threads[i].getState());
				status[i] = threads[i].getState();
			}
			for(int i=0;i<10;i++){
				threads[i].start();
			}
			boolean finish = false;
			while(!finish){
				for(int i=0;i<10;i++){
					if(threads[i].getState()!=status[i]){
						writeThreadInfo(pw,threads[i],status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for(int i=0 ;i<10;i++){
					finish = finish && (threads[i].getState() ==State.TERMINATED);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			pw.close();
		}
		
	}
	private static void writeThreadInfo(PrintWriter pw,Thread thread,State state){
		pw.printf("main : id %d - %s \n", thread.getId(),thread.getName());
		pw.printf("main : priority : %d\n", thread.getPriority());
		pw.printf("main : Old state %s \n",state );
		pw.printf("main : New state %s \n", thread.getState());
		pw.printf("main : **************************\n" );
	}
}
