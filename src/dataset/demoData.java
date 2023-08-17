package dataset;

public class demoData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 7, 8, 11};
		int[] b = {2, 6, 8};
		
		mergeArray(a, b);
	}

	public static void mergeArray(int[] arrA, int[] arrB) {
		int a_len = arrA.length;
		int b_len = arrB.length;
		int c_len = a_len + b_len;
		int i = 0, j = 0, k = 0;
		
		int arrC[] = new int[c_len];
		
		while((i< a_len) &&(j< b_len)) {
			if(arrA[i]> arrB[j]) {
				arrC[k] = arrB[j];
				j++;
			}
			else {
				arrC[k] = arrA[i];
				i++;
			}
			k++;
		}
		
		while(i < a_len) {
			arrC[k] = arrA[i];
			i++;
		}
		
		while(j < b_len) {
			arrC[k] = arrB[j];
			j++;
		}
		
		for(int m=0; m< arrC.length; m++)
			System.out.println(arrC[m]);
		
	}
}
