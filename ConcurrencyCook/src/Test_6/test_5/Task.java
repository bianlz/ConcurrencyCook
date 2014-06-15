package Test_6.test_5;

import java.util.concurrent.ConcurrentSkipListMap;

public class Task implements Runnable {
	private ConcurrentSkipListMap<String, Contect> map;
	private String id;
	public Task(ConcurrentSkipListMap<String, Contect> map,String id){
		this.map = map;
		this.id = id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			Contect contact = new Contect(id, String.valueOf(i+1000));
			map.put(id+contact.getPhone(),contact);
		}
	}

}
