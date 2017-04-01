import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Drew Rife
 * 
 * Class for quicksorting
 *
 */
public class QuickSorter 
{
	private static int start;
	private static int end;
	private static Random random = new Random();
	private static int[] randomValues = new int[3];
	private static int pivotIndex;
	
	public QuickSorter() {}
	
	/**
	 * quick sorts an array
	 * 
	 * @param numbersToSort
	 * @param rightPosition 
	 * @param leftPosition 
	 * @param outputFile
	 */
	public void quickSort(int[] numbersToSort, int leftPosition, int rightPosition)
	{
		if(leftPosition < rightPosition)
		{
			/* get the pivot index and swap the value at pivot index with left position */
			pivotIndex = getPivotIndex(numbersToSort);
			swap(numbersToSort, pivotIndex, leftPosition);
						
			partitionList(numbersToSort, leftPosition, rightPosition);
			quickSort(numbersToSort, leftPosition, start-1);
			quickSort(numbersToSort, end+1, rightPosition);
		}
	}

	/**
	 * partitions the array passed in based on the Dutch Flag 3-way partition
	 * 
	 * @param numbersToSort
	 * @param startPosition
	 * @param endPosition
	 * @param endPosition 
	 */
	private void partitionList(int[] numbersToSort, int leftPosition, int rightPosition) 
	{
		start = leftPosition;
		int i = leftPosition;
		end = rightPosition;
		
		/* the pivot value is in the leftPosition of the array */
		int pivot = numbersToSort[leftPosition];
		
		
		while(i <= end)
		{
			if(numbersToSort[i] < pivot)
			{
				swap(numbersToSort, i++, start++);
			}
			else if(numbersToSort[i] > pivot)
			{
				swap(numbersToSort, i, end--);
			}
			else
			{
				i++;
			}
		}
	}

	/* swaps values in numbers to sort array */
	private void swap(int[] list, int valueAtIndex1, int valueAtIndex2) 
	{
		int temp = list[valueAtIndex1];
		list[valueAtIndex1] = list[valueAtIndex2];
		list[valueAtIndex2] = temp;
	}

	/**
	 * gets a pivot value by taking the median of 3 randomly chose values from the list
	 * @param numbersToSort
	 * @return the pivot value
	 */
	private int getPivotIndex(int[] numbersToSort) 
	{
		for(int i = 0; i < 3; i++)
		{
			int randomlyChosenValue = random.nextInt(numbersToSort.length);
			randomValues[i] = randomlyChosenValue;
		}
		
		if(randomValues[0] > randomValues[1])
			swap(randomValues, 0, 1);
		
		if(randomValues[1] > randomValues[2])
			swap(randomValues, 1, 2);
		
		if(randomValues[0] < randomValues[1])
			swap(randomValues, 0, 1);
		
		int pivotIndex = 0;
		boolean foundPivot = false;
		for(int i = 0; (i <= numbersToSort.length-1) && !foundPivot; i++)
		{
			if(numbersToSort[i] == randomValues[1])
			{
				pivotIndex = i;
				foundPivot = true;
			}
		}
		
		return pivotIndex;
	}
}
