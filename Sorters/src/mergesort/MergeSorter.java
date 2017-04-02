package mergesort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Drew Rife
 * 
 * MergeSorter that merge sorts a list
 */
public class MergeSorter 
{
	private int[] copyOfNumbersToSort1;
	private int[] copyOfNumbersToSort2;
	
	public void sort(int[] numbersToSort)
	{
		this.copyOfNumbersToSort1 = numbersToSort;
		this.copyOfNumbersToSort2 = new int[numbersToSort.length];
		mergeSort(0, numbersToSort.length-1);
	}
	
	public void mergeSort(int start, int end)
	{
		if(start < end)
		{
			int middle = start + (end - start) / 2;
			mergeSort(start, middle);
			mergeSort(middle+1, end);
			merge(start, middle, end);
		}
	}

	private void merge(int start, int middle, int end) 
	{
		for(int i = start; i <= end; i++)
		{
			this.copyOfNumbersToSort2[i] = this.copyOfNumbersToSort1[i];
			
			int s = start;
			int temp = start;
			int m = middle+1;
			
			while(s <= middle && m <= end)
			{
				if(this.copyOfNumbersToSort2[s] <= this.copyOfNumbersToSort2[m])
					this.copyOfNumbersToSort1[temp] = this.copyOfNumbersToSort2[s++];
				else
					this.copyOfNumbersToSort1[temp] = this.copyOfNumbersToSort2[m++];
				
				temp++;
			}
			
			while(s <= middle) 
			{
				this.copyOfNumbersToSort1[temp++] = this.copyOfNumbersToSort1[s++];
			}
		}
	}

//	private void makeCopies(int[] numbersToSort) 
//	{
//		Range rangeAToB = new Range(0, ((numbersToSort.length/2) -1));
//		Range rangeAToC1 = new Range((numbersToSort.length/2), numbersToSort.length-1);
//		Range rangeAToC2 = new Range(0, (int) (Math.ceil(numbersToSort.length/2)-1));
//		
//		/* copy a to b */
//		for(int i = rangeAToB.getX(); i <= rangeAToB.getY(); i++)
//		{
//			this.copyOfNumbersToSort1[i] = numbersToSort[i];
//		}
//		
//		/* copy from a to c */
//		int j = rangeAToC2.getX();
//		for(int i = rangeAToC1.getX(); i <= rangeAToC1.getY(); i++)
//		{
//			this.copyOfNumbersToSort2[j] = numbersToSort[i];
//			j++;
//		}
//	}
	
//	private class Range
//	{
//		private int x;
//		private int y;
//		
//		public Range(int x, int y)
//		{
//			this.x = x;
//			this.y = y;
//		}
//		
//		public int getX() { return this.x; }
//		public int getY() { return this.y; }
//	}
//
//	public int[] mergeSort(int[] arrayA) 
//	{
//		if(arrayA.length > 1)
//		{
//			makeCopies(arrayA);
//			
//		}
//		
//		return numbersToSort;
//		
//	}
//
//	private void makeCopies(int[] arrayA) 
//	{
//		this.arrayB = new int[arrayA.length/2];
//		this.arrayC = new int[arrayA.length - arrayB.length];
//		
//		System.arraycopy(arrayA, 0, arrayB, 0, arrayB.length);
//		System.arraycopy(src, srcPos, dest, destPos, length);
//	}
}
