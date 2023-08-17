package dataset;

//���Լ��
public class GreatestNum {

	//շת�����
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
		
		//һ��������ʮ���ƣ�λ��1�Ľ����1��һ��ż����ʮ���ƣ�λ��1�Ľ����0
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
