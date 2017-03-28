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
	 * @param endPosition 
	 * @param startPosition 
	 * @param outputFile
	 */
	public void quickSort(ArrayList<Integer> numbersToSort, int startPosition, int endPosition, String outputFile)
	{
		if(startPosition <= endPosition)
		{
			int pivot = getPivotValue(numbersToSort);
			paritionArray(numbersToSort, pivot, startPosition, endPosition);
			
			this.quickSort(numbersToSort, startPosition, this.start, outputFile);
			this.quickSort(numbersToSort, this.end+1, endPosition, outputFile);
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
		this.start = startPosition-1;
		this.end = endPosition;
		int middle = startPosition;
		
		while(middle < this.end)
		{
			if(numbersToSort.get(middle) < pivot)
			{
				int temp  = numbersToSort.get(this.start+1);
				numbersToSort.set((this.start+1), numbersToSort.get(middle));
				numbersToSort.set(middle, temp);
				this.start++;
				middle++;
			}
			else if(numbersToSort.get(middle) == pivot)
			{
				middle++;
			}
			else
			{
				int temp = numbersToSort.get(this.end-1);
				numbersToSort.set(this.end-1, numbersToSort.get(middle));
				numbersToSort.set(middle, temp);
				end--;
			}
		}
		
		int temp = numbersToSort.get(middle);
		numbersToSort.set(middle, numbersToSort.get(endPosition));
		numbersToSort.set(endPosition, temp);
		System.out.println(this.start + " " + this.end);
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
