package Test_6.test_5;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<String, Contact>(); 
		Thread threads[] = new Thread[25];
		int counter = 0;
		for(char i='A' ;i<'Z';i++){
			Task task = new Task(map,String.valueOf(i));
			threads[counter]= new Thread(task);
			threads[counter].start();
			counter++;
		}
		for(int i=0;i<25;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Main: sizr of the map: %d \n",map.size());
		Map.Entry<String, Contact> element = map.firstEntry();
		Contact contact = element.getValue();
		System.out.printf("Main : First Entry: %s %s \n",contact.getName(),contact.getPhone());
		element = map.lastEntry();
	    contact = element.getValue();
		System.out.printf("Main : Last Entry: %s %s \n",contact.getName(),contact.getPhone());
		System.out.printf("Main: submap from A1996 to B1002 \n");
		ConcurrentNavigableMap<String, Contact> subMap = map.subMap("A1996", "B1002");	
		do{
			element = subMap.pollFirstEntry();
			if(null!=element){
				contact = element.getValue();
				System.out.printf("%s :%s \n",contact.getName(),contact.getPhone());
			}
		}while(element!=null);
	}

}
