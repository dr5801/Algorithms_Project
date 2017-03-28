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
	private int start;
	private int end;
	
	/**
	 * quick sorts an array
	 * 
	 * @param numbersToSort
	 * @param upperEnd 
	 * @param lowerEnd 
	 * @param outputFile
	 */
	public void quickSort(ArrayList<Integer> numbersToSort, int lowerEnd, int upperEnd, String outputFile)
	{
		if(lowerEnd <= upperEnd)
		{
			int pivot = getPivotValue(numbersToSort);
			paritionArray(numbersToSort, pivot, lowerEnd, upperEnd);
			
			quickSort(numbersToSort, lowerEnd, this.start, outputFile);
			quickSort(numbersToSort, this.end+1, upperEnd, outputFile);
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
	private void paritionArray(ArrayList<Integer> numbersToSort, int pivot, int startPosition, int endPosition) 
	{
		start = 0;
		end = 0;
		int n = numbersToSort.size() - 1;
		
		while(end <= n)
		{
			if(numbersToSort.get(end) < pivot)
			{
				swap(numbersToSort, start, end);
				start++;
				end++;
			}
			else if(numbersToSort.get(end) > pivot)
			{
				swap(numbersToSort, end, n);
			}
			else
			{
				end++;
			}
		}
	}

	/* swaps values in numbers to sort array */
	private void swap(ArrayList<Integer> numbersToSort, int valueAtIndex1, int valueAtIndex2) 
	{
		int temp = numbersToSort.get(valueAtIndex1);
		numbersToSort.set(valueAtIndex1, numbersToSort.get(valueAtIndex2));
		numbersToSort.set(valueAtIndex2, temp);		
	}

	/**
	 * gets a pivot value by taking the median of 3 randomly chose values from the list
	 * @param numbersToSort
	 * @return the pivot value
	 */
	private int getPivotValue(ArrayList<Integer> numbersToSort) 
	{
		int[] values = new int[3];
		Random randomValue = new Random();
		
		for(int i = 0; i < 3; i++)
		{
			values[i] = numbersToSort.get(randomValue.nextInt(numbersToSort.size()));
		}
		
		Arrays.sort(values);
		
		/* return the median value */
		return values[1];
	}
}
