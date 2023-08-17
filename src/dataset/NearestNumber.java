package dataset;

import java.util.Arrays;

public class NearestNumber {

	private static int[] findNearestNumber(int[] numbers) {
		//找到逆序边界
		int index = findTransferPoint(numbers);
		
		if(index == 0) {
			return null;
		}
		
		//把逆序区域的前一位和逆序区域刚好大于它的数字交换位置
		int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
		exchangeHead(numbersCopy, index);
		//原来的逆序转为顺序
		reverse(numbersCopy, index);
		return numbersCopy;
	}
	
	//查找低位逆序区域
	private static int findTransferPoint(int[] numbers) {
		for(int i = numbers.length -1; i > 0; i--) {
			if(numbers[i] > numbers[i-1]) {
				return 1;
			}
		}
		return 0;
	}
	
	private static int[] exchangeHead(int[] numbers, int index) {
		int head = numbers[index-1];
		for(int i=numbers.length-1; i>0;i--) {
			if(head < numbers[i]) {
				numbers[index -1]= numbers[i];
				numbers[i] = head;
				break;
			}
		}
		return numbers;
	}
	
	private static int[] reverse(int[] num, int index) {
		for(int i = index, j = num.length -1; i<j; i++, j--) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 2, 3, 4, 5};
		for(int i = 0; i < 10; i++) {
			numbers = findNearestNumber(numbers);
			outputNumbers(numbers);
		}
	}

	private static void outputNumbers(int[] numbers) {
		for(int i: numbers) {
			System.out.print(i);
		}
		System.out.println();
	}
}
