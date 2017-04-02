package heapsort;

import sharedClasses.Swapper;

/**
 * HeapSort that has the functionality of heap sorting a list
 * 
 * @author Drew Rife
 *
 */
public class HeapSorter 
{
	public int[] heapSort(int[] numbersToSort)
	{
		int[] listOfMaxKeys = new int[numbersToSort.length];
		numbersToSort = heapify(numbersToSort);
		
		for(int i = listOfMaxKeys.length-1; i > -1; i--)
		{
			listOfMaxKeys[i] = numbersToSort[0];
			numbersToSort = deleteMaxKey(numbersToSort);
			numbersToSort = heapify(numbersToSort);
		}
		return listOfMaxKeys;
	}

	/**
	 * heapifies the list
	 * 
	 * @param numbersToSort
	 * @return list that has been heapified
	 */
	private int[] heapify(int[] numbersToSort) 
	{
		boolean hasBeenHeaped = false;
		
		for(int i = (numbersToSort.length/2)-1; i > -1; i--)
		{
			int keyIndex = i;
			int keyValue = numbersToSort[keyIndex];
			
			while(!hasBeenHeaped && ((2*keyIndex) <= (numbersToSort.length-1)))
			{
				int j = (2*keyIndex);
				
				if(j < (numbersToSort.length-1))
				{
					if(numbersToSort[j] < numbersToSort[j+1]) 
					{
						j++;
					}
				}
				
				if(keyValue >= numbersToSort[j])
				{
					hasBeenHeaped = true;
				}
				else
				{
					numbersToSort[keyIndex] = numbersToSort[j];
					keyIndex = j;
				}
				
				numbersToSort[keyIndex] = keyValue;
			}
		}
		
		return numbersToSort;
	}

	/**
	 * delete the max key in numbersToSort
	 * 
	 * @param numbersToSort
	 * @return
	 */
	private int[] deleteMaxKey(int[] numbersToSort) 
	{
		if(numbersToSort.length == 1)
		{
			return numbersToSort;
		}
		else
		{
			Swapper.swapArray(numbersToSort, 0, numbersToSort.length-1);
			
			/* make a new array that excludes the max key within numbersToSort */
			int[] newArray = new int[numbersToSort.length-1];
			System.arraycopy(numbersToSort, 0, newArray, 0, newArray.length);
			
			return newArray;
		}
	}
}
