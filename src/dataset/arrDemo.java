package dataset;

public class arrDemo {
	private int[] arr;
	private int size;
	
	public arrDemo(int capacity) {
		this.arr = new int[capacity];
		size = 0;
	}
	
	public void insert (int index, int value) throws Exception {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Beyond array field");
		}
		if(size >= arr.length) {
			resize();
		}
		for(int i = size -1; i >= index; i--) {
			arr[i+1] = arr[i]; 
		}
		arr[index] = value;
		size++;
	}
	
	public void resize() {
		int[] arrnew = new int[arr.length * 2];
		System.arraycopy(arr, 0, arrnew, 0, arr.length);
		arr =  arrnew;
	}
	
	public int delete(int index) throws Exception {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Beyond array field");
		}
		int delval = arr[index];
		
		for(int i= index; i< size -1; i++ ) {
			arr[i] = arr[i+1];
		}
		size--;
		return delval;
	}
}
