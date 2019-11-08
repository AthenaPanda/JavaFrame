package tree_test;

import java.util.*;

public class DBSample {
	
	static int idList = 1;
	
	public DBSample()
	{
		List<String> list_pri = new LinkedList<>(); // Linkedlist implements list
		list_pri.add("Jim");
		list_pri.add("Cale");
		list_pri.add("Norm");
		
		List<String> list_sec = new LinkedList<>();
		list_sec.add("Cary");
		list_sec.add("Sam");
		list_sec.add("Simonson");
		
		ListIterator<String> priIter = list_pri.listIterator();
		Iterator<String> secIter = list_sec.iterator();
		
		while(secIter.hasNext())
		{
			if(priIter.hasNext()) priIter.next();
			priIter.add(secIter.next());
		}
		System.out.println(list_pri);
		
		secIter = list_sec.iterator();
		while(secIter.hasNext())
		{
			secIter.next();
			while(secIter.hasNext())
			{
				secIter.next();
				secIter.remove();
			}
		}
		System.out.println(list_sec);
		
		list_pri.removeAll(list_sec);
		System.out.println(list_pri);
				
	}

}
