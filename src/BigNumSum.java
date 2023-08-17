
public class BigNumSum {

	public static String bigNumberSum(String bigNumberA, String bigNumberB) {
		int maxLength = bigNumberA.length() > bigNumberB.length()?bigNumberA.length():bigNumberB.length();
		int[] arrayA = new int[maxLength + 1];
		for(int i = 0; i < bigNumberA.length(); i++) {
			arrayA[i] = bigNumberA.charAt(bigNumberA.length() -1-i) - '0';
		}
		//分别逆序存储
		int[] arrayB = new int[maxLength + 1];
		for(int i = 0; i < bigNumberB.length(); i++) {
			arrayB[i] = bigNumberB.charAt(bigNumberB.length() -1-i) - '0';
		}
		
		int[] result = new int[maxLength + 1];
		//遍历数组，按位相加
		for(int i= 0 ;i < result.length; i++) {
			
			int temp  = result[i];
			temp += arrayA[i];
			temp += arrayB[i];
			if(temp >= 10) {
				temp = temp -10;
				result[i+1] = 1;
			}
			result[i] = temp;
		}
		
		//相加完成后再次逆序转换
		StringBuilder str = new StringBuilder();
		boolean findFirst = false;
		for(int i = result.length -1; i >= 0; i--) {
			if(!findFirst) {
				if(result[i] == 0) {
					continue;
				}
				findFirst = true;
			}
			str.append(result[i]);
		}
		return str.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(bigNumberSum("426709752318", "95481233129"));
	}
}
