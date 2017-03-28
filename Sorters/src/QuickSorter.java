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
	 * @param numbersToSort
	 * @param outputFile
	 */
	public void quickSort(ArrayList<Integer> numbersToSort, String outputFile)
	{
		int pivot = getPivotValue(numbersToSort);
		System.out.println(pivot);
		
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
