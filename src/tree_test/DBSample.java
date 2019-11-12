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
