package dataset;

public class sortDemo {
	
	public static void bubble_sort_v1(int arr[])
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j= 0; j < arr.length - 1 - i; j++)
			{
				int tmp = 0;
				if(arr[j] > arr[j+1])
				{
					 tmp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void bubble_sort_v2(int arr[])
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			boolean sorted = true;
			for(int j= 0; j < arr.length - 1 - i; j++)
			{
				int tmp = 0;
				if(arr[j] > arr[j+1])
				{
					 tmp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = tmp;
					 sorted = false;
				}
			}
			if(sorted) break;
		}
	}

	public static void bubble_sort_v3(int arr[])
	{
		int lastChangeId = 0;
		
		int sortBorder = arr.length -1;
		for(int i = 0; i < sortBorder; i++)
		{
			boolean sorted = true;
			for(int j= 0; j < arr.length - 1 - i; j++)
			{
				int tmp = 0;
				if(arr[j] > arr[j+1])
				{
					 tmp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = tmp;
					 sorted = false;
					 lastChangeId = j;
				}
			}
			sortBorder = lastChangeId;
			if(sorted) break;
		}
	}
	
	public static void cocktail_sort(int arr[])
	{
		for(int i= 0; i< arr.length/2; i++)
		{
			if(i%2 == 0) {
				for(int j = i; j< arr.length - 1 -i; j++)
				{
					int tmp = 0;
					
					if(arr[j] > arr[j+1])
					{
						tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
			else {
				for(int k=arr.length-1-i; k > i ; k--)
				{
					int tmp2 = 0;
					if(arr[k] < arr[k-1])
					{
						tmp2 = arr[k];
						arr[k] = arr[k-1];
						arr[k-1]= tmp2;
					}
				}
			}
		}
	}
	
	/* quick sort start */
	public static void quickSort(int arr[], int startIndex, int endIndex)
	{
		if(startIndex >= endIndex) {
			return;
		}
		
		int pivlotIndex = partition(arr, startIndex, endIndex);
		
		quickSort(arr, startIndex, pivlotIndex - 1);
		quickSort(arr, pivlotIndex + 1, endIndex);
	}
	
	private static int partition(int[] arr, int startIndex, int endIndex)
	{
		int pivlot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left != right)
		{
			while(left < right && arr[right] > pivlot)
			{
				right--;
			}
			
			while(left < right && arr[left] < pivlot) 
			{
				left++;
			}
			
			if(left < right)
			{
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			
		}
		arr[startIndex] = arr[left];
		arr[left] = pivlot;
		
		return left;
	}
	/* quick sort end */
	private static int partition_single(int[] arr, int startIndex, int endIndex)
	{
		int pivlot = arr[startIndex];
		int mark = startIndex;

		for(int i= startIndex +1 ; i<= endIndex; i++)
		{
			if(arr[i] < pivlot)
			{
				mark++;
				int tmp = arr[i];
				arr[i] = arr[mark];
				arr[mark] = tmp;
			}
		}

		arr[startIndex] = arr[mark];
		arr[mark] = pivlot;
		
		return mark;
	}
	
	/* count sort start */
	public void countSort(int[] arr)
	{
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i < arr.length;i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
			
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		
		int[] countArr = new int[max - min +1];
		for(int i= 0; i < arr.length; i++)
		{
			countArr[arr[i]-min]++;
		}
		
		int index = 0;
		
	}
}
