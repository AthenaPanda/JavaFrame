package dataset;

public class NumCheck {

	public static int[] findLostNum(int[] array) {
		int[] result = new int[2];
		
		int xorResult = 0;
		for(int i = 0; i < array.length;i++) {
			xorResult ^= array[i];
		}
		
		if(xorResult == 0) {
			return null;
		}
		
		//确定2个整数的不同位
		int separator = 1;
		while( 0 == (xorResult&xorResult)) {
			separator<<=1;
		}
		
		for(int i = 0; i < array.length; i++) {
			if( 0 == (array[i] & separator)) {
				result[0] ^= array[i];
			}
			else {
				result[1] ^= array[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
