package dataset;

public class Powerto2 {

	public static boolean isPowerof2_V1(int num){
		int temp = 1;
		while(temp <= num) {
			if(temp == num) {
				return true;
			}
			temp = temp << 1;
		}
		return false;
	}
	
	public static boolean isPowerof2_V2(int num) {
		return (num & (num -1)) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerof2_V2(326));
	}

}
