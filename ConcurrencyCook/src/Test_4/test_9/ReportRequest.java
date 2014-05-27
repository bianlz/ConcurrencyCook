package Test_4.test_9;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable {
	private String name;
	
	private CompletionService<String> service;
	
	public ReportRequest(String name,CompletionService<String> service){
		this.name = name;
		this.service = service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		service.submit(reportGenerator);
	}

}
