package dataset;

//最大公约数
public class GreatestNum {

	//辗转相除法
	public static int getGreatestCommonDivisorV1(int a, int b) {
		int big = a > b?a:b;
		int small = a < b? a:b;
		if(big%small == 0) {
			return small;
		}
		return getGreatestCommonDivisorV1(big%small, small);
	}
	
	public static int getGreatestCommonDivisorV2(int a, int b) {
		if(a == b) {
			return a;
		}
		int big = a > b?a:b;
		
		int small = a < b? a:b;

		return getGreatestCommonDivisorV2(big-small, small);
	}
	
	public static int gcd(int a, int b) {
		if(a == b) {
			return a;
		}
		
		//一个奇数（十进制）位与1的结果是1，一个偶数（十进制）位与1的结果是0
		if((a&1) == 0 && (b&1)==0) {
			return gcd(a>>1, b>>1)<<1;
		}else if((a&1)== 0 &&(b&1)!= 0) {
			return gcd(a>>1, b);
		}
		else {
			int big = a >b?a:b;
			int small = a<b?a:b;
			return gcd(big -small, small);
		}
	}
}
