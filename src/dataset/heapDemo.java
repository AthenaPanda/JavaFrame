package dataset;

/*
 * Minimum Heap
 */
public class heapDemo {
	
	
	public void upAdjust(int[] arr) {
		int childIndex = arr.length - 1;
		int parentIndex = (childIndex + 1)/2;
		
		int temp = arr[childIndex];
		
		while(childIndex > 0 && temp < arr[parentIndex])
		{
			arr[childIndex] = arr[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex + 1)/2;
		}
		arr[parentIndex] = temp;
	}
	
	public void downAdjust(int[] arr, int parentIndex, int length) {
		int temp = arr[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		
		while(childIndex < length) {
			if(childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
				childIndex++;
			}
			
			if(temp < arr[childIndex])
				childIndex++;
			
			arr[parentIndex] = arr[childIndex];
			parentIndex = childIndex;
			childIndex = parentIndex *2 + 1;
		}
		arr[childIndex] = temp;
	}
	
	public void buildHeap(int[] arr) {
		for(int i= (arr.length -2)/2; i >= 0; i--) {
			downAdjust(arr, i, arr.length);
		}
	}

}
