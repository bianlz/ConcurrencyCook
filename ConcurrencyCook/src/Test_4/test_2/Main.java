package Test_4.test_2;

public class Main {
	public static void main(String args[]){
		Server server = new Server();
		for(int i=0;i<100;i++){
			Task task = new Task("task"+i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
