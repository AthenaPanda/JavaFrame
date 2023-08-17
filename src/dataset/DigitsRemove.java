package dataset;

public class DigitsRemove {

	public static String removeDigits_v1(String num, int k) {
		
		//新数字长度
		int newLength = num.length() - k;
		char[] stack = new char[num.length()];
		int top = 0;
		for(int i = 0; i < num.length(); ++i) {
			//遍历当前数字
			char c = num.charAt(i);
			
			//栈顶数字大于遍历到当前数字时，栈顶数字出栈，即删除
			while(top > 0 && stack[top -1] > c && k >0) {
				top -= 1;
				k -= 1;
			}
			//遍历到的数字入栈
			stack[top++] = c;
		}
		
		//数字中第一个非零位置，构建新的整数字符串
		int offset = 0;
		while(offset < newLength && stack[offset] == '0') {
			offset++;
		}
		return offset == newLength? "0": new String(stack, offset,newLength - offset);
	}
	
	public static void main(String[] args) {
		System.out.println(removeDigits_v1("1592312", 4));
	}
}
