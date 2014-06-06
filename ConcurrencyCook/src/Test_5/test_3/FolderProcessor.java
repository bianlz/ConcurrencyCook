package Test_5.test_3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {
	private static final long serialVersionUID = 1L;
	private String path;
	private String extension;
	public FolderProcessor(String path,String extension){
		this.path = path;
		this.extension = extension;
	}
	protected List<String> compute() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		File file = new File(path);
		File[] files = file.listFiles();
		if(null!=files){
			for(int i=0;i<files.length;i++){
				if(files[i].isDirectory()){
					FolderProcessor task = new FolderProcessor(files[i].getAbsolutePath(),this.extension);
					task.fork();
					tasks.add(task);
				}else{
					if(this.checkFile(files[i].getName())){
						list.add(files[i].getAbsolutePath());
					}
				}
			}
			if(list.size()>50){
				System.out.printf("%s: %d tasks ran.\n",file.getAbsolutePath(),tasks.size());

			}
			this.addResultsFromTasks(list, tasks);
		}
		return list;
	}
	private void addResultsFromTasks(List<String> list , List<FolderProcessor> tasks){
		for(FolderProcessor task:tasks){
			list.addAll(task.join());
		}
		
	}
	private boolean checkFile(String name){
		return name.endsWith(this.extension);
	}
}
