package tree_test;

import javax.swing.*;

public class PermutationSpinnerModel extends AbstractSpinnerModel 
{
	private String word;
	public PermutationSpinnerModel(String w)
	{
		word  = w;
	}

	@Override
	public Object getNextValue() {
		int[] codePoints = toCodePointArray(word);
		for(int i = codePoints.length-1; i>0; i--)
		{
			if(codePoints[i-1] < codePoints[i])
			{
				int j = codePoints.length - 1;
				while(codePoints[i-1] < codePoints[j])
					j--;
				swap(codePoints, i-1, j);
				reverse(codePoints, i, codePoints.length - 1);
				return new String(codePoints, 0, codePoints.length);
			}
		}
		reverse(codePoints, 0, codePoints.length - 1);
		return new String(codePoints, 0, codePoints.length);
	}

	@Override
	public Object getPreviousValue() {
		int[] codePoints = toCodePointArray(word);
		for(int i = codePoints.length-1; i>0; i--)
		{
			if(codePoints[i-1] > codePoints[i])
			{
				int j = codePoints.length - 1;
				while(codePoints[i-1] < codePoints[j])
					j--;
				swap(codePoints, i-1, j);
				reverse(codePoints, i, codePoints.length - 1);
				return new String(codePoints, 0, codePoints.length);
			}
		}
		reverse(codePoints, 0, codePoints.length - 1);
		return new String(codePoints, 0, codePoints.length);
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return word;
	}

	@Override
	public void setValue(Object value) {
		if(!(value instanceof String)) throw new IllegalArgumentException();
		word = (String)value;
		fireStateChanged();
	}
	
	private static int[] toCodePointArray(String str)
	{
		int[] codePoints = new int[str.codePointCount(0, str.length())];//字符串长度的数组
		for(int i = 0, j = 0; i < str.length(); i++, j++)
		{
			int cp = str.codePointAt(i);
			if(Character.isSupplementaryCodePoint(cp)) i++;//是否为空白，跳过
			codePoints[j] = cp;
		}
		return codePoints;
	}
	
	public static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void reverse(int[] a, int i, int j)
	{
		while(i<j)
		{
			swap(a, i, j);
			i++;
			j--;
		}
	}	
}
