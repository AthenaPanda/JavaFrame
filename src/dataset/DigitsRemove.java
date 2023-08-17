package dataset;

public class DigitsRemove {

	public static String removeDigits_v1(String num, int k) {
		
		//�����ֳ���
		int newLength = num.length() - k;
		char[] stack = new char[num.length()];
		int top = 0;
		for(int i = 0; i < num.length(); ++i) {
			//������ǰ����
			char c = num.charAt(i);
			
			//ջ�����ִ��ڱ�������ǰ����ʱ��ջ�����ֳ�ջ����ɾ��
			while(top > 0 && stack[top -1] > c && k >0) {
				top -= 1;
				k -= 1;
			}
			//��������������ջ
			stack[top++] = c;
		}
		
		//�����е�һ������λ�ã������µ������ַ���
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
