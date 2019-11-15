package tree_test;

import java.util.*;
import base_test.*;

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
		
		/*
		 * TreeSet with Comparator interface
		 * sort by partNumber; sort by description
		 */
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("toa", 1234));
		parts.add(new Item("mea", 2267));
		parts.add(new Item("crc", 765));
		System.out.println(parts);
		
		SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>()
				{
					public int compare(Item a, Item b)
					{
						String desA = a.GetDescription();
						String desB = b.GetDescription();
						return desA.compareTo(desB);
					}
				});
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
		
		/*
		 * PriorityQueue 
		 * sort by default --YEAR
		 */
		PriorityQueue<GregorianCalendar> calQueue = new PriorityQueue<>();
		calQueue.add(new GregorianCalendar(1908, Calendar.DECEMBER, 9));
		calQueue.add(new GregorianCalendar(1836, Calendar.DECEMBER, 10));
		calQueue.add(new GregorianCalendar(1901, Calendar.DECEMBER, 5));
		calQueue.add(new GregorianCalendar(1918, Calendar.JULY, 22));
		
		System.out.println("Iterating every elements....");
		for(GregorianCalendar date: calQueue)
			System.out.println(date.get(Calendar.YEAR));
		System.out.println("Removing Elements....");
		while(!calQueue.isEmpty())
			System.out.println(calQueue.remove().get(Calendar.YEAR));				
		
		/*
		 * Map
		 * method sample
		 */
		Map<String, Employee> staff = new HashMap<>();
	    staff.put("144-25-5564", new Employee("Amy Lee", 1000, 1988, 9, 25));
	    staff.put("567-24-2546", new Employee("Harry Hacker", 2000, 1979, 3, 13));
	    staff.put("157-62-7935", new Employee("Gary Cooper", 1500, 1990, 12, 3));
	    staff.put("456-62-5527", new Employee("Frank Cruz", 3000, 1969, 7, 10));
	    
	    System.out.println(staff);
	    
	    //remove an Entry
	    staff.remove("567-24-2546");
	    
	    //replace an Entry
	    staff.put("456-62-5527", new Employee("Cate Kacy", 2000, 1973, 6, 20));
	    
	    System.out.println(staff.get("157-62-7935"));
	    
	    for(Map.Entry<String, Employee> entry: staff.entrySet())
	    {
	    	String key = entry.getKey();
	    	Employee value = entry.getValue();
	    	System.out.println("Key=" + key +",Value=" + value.getName());
	    }
	    
	}

}

class Item implements Comparable<Item> { 
	private String description;
	private int partNumber;
	
	public Item(String aDescription, int aPartNumber)
	{
		description = aDescription;
		partNumber  = aPartNumber;
	}
	
	public String GetDescription()
	{
		return description;
	}
	
	public int GetPartNumber()
	{
		return partNumber;
	}
	
	public String toString()
	{
		return "[description=" + description + ", partNumber=" + partNumber + "]";
	}
	
	public boolean equals(Object otherObj)
	{
		if(this == otherObj) return true;
		if(otherObj == null) return false;
		if(getClass()!= otherObj.getClass()) return false;
		Item other = (Item)otherObj;
		return Objects.equals(description, other.description) && partNumber == other.partNumber ;
	}
	
	public int hashCode()
	{
		return Objects.hash(description, partNumber);
	}
	
	public int compareTo(Item other)
	{
		return Integer.compare(partNumber, other.partNumber);
	}
	
}
