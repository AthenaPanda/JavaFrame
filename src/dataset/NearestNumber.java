package dataset;

import java.util.Arrays;

public class NearestNumber {

	private static int[] findNearestNumber(int[] numbers) {
		//�ҵ�����߽�
		int index = findTransferPoint(numbers);
		
		if(index == 0) {
			return null;
		}
		
		//�����������ǰһλ����������պô����������ֽ���λ��
		int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
		exchangeHead(numbersCopy, index);
		//ԭ��������תΪ˳��
		reverse(numbersCopy, index);
		return numbersCopy;
	}
	
	//���ҵ�λ��������
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
