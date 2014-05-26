package Test_1.test_4;

import java.io.File;

public class FileSearch implements Runnable {
	private String initPath;
	private String fileName;
	public FileSearch(String path,String fileName){
		this.initPath = path;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(initPath);
		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread
						.currentThread().getName());
			}
		}
	}
	private void directoryProcess(File file)throws InterruptedException{
		File[] files = file.listFiles();
		if(null!=files){
			for(File f:files){
				if (f.isDirectory()) {
					directoryProcess(f);
				} else {
					fileProcess(f);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}

	}
	private void fileProcess(File file)throws InterruptedException{
		if (file.getName().equals(fileName)) {
			 System.out.printf("%s : %s\n",Thread.currentThread().getName() ,file.getAbsolutePath());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
}
