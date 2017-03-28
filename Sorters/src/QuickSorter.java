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
		int pivot = getPivotValue(numbersToSort);
		paritionArray(numbersToSort, startPosition, endPosition);
		
	}

	/**
	 * partitions the array passed in based on the Dutch Flag 3-way partition
	 * 
	 * @param numbersToSort
	 * @param startPosition
	 * @param endPosition
	 */
	private void paritionArray(ArrayList<Integer> numbersToSort, int startPosition, int endPosition) 
	{
		// TODO Auto-generated method stub
		
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
