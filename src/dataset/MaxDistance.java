package dataset;

public class MaxDistance {

	private static class Bucket{
		Integer min;
		Integer max;
	}
	
	public static int getMaxSortedDistance(int[] array) {
		
		//��ȡ����������Сֵ
		int max = array[0];
		int min = array[0];
		for(int i = 0; i< array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
			
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		int d= max - min;
		//���Ǳ߽缫�����������Ԫ����ͬ
		if( d == 0) {
			return 0;
		}
		
		//��ʼ��Ͱ
		int bucketNum = array.length;
		Bucket[] buckets = new Bucket[bucketNum];
		for(int i = 0; i < bucketNum; i++) {
			buckets[i] = new Bucket();
		}
		
		//�������飬ȷ��ÿ��Ͱ��������Сֵ
		for(int i = 0; i < bucketNum; i++) {
			//ȷ������Ԫ��������Ͱ�±�
			int index = ((array[i] - min) * (bucketNum -1)/d);
			
			if(buckets[index].min == null || buckets[index].min > array[i]) {
				buckets[index].min = array[i];
			}

			if(buckets[index].max == null || buckets[index].max < array[i]) {
				buckets[index].max = array[i];
			}
		}
		
		//����Ͱ���ҵ�����ֵ
		int leftMax = buckets[0].max;
		int maxDistance = 0;
		
		for(int i = 0; i < buckets.length; i++) {
			if(buckets[i].min == null) {
				continue;
			}
			
			if(buckets[i].min -leftMax > maxDistance) {
				maxDistance = buckets[i].min - leftMax;
			}
			leftMax = buckets[i].max;
		}
		
		return maxDistance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2, 5, 3, 9, 1, 26, 5, 14, 20};
		System.out.println(getMaxSortedDistance(arr));
	}

}
