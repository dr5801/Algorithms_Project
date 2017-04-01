import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 
 * @author Drew Rife
 * 
 * Class for quicksorting
 *
 */
public class QuickSorter 
{
	public QuickSorter() {}
	
	/**
	 * quick sorts an array
	 * 
	 * @param numbersToSort
	 * @param upperEnd 
	 * @param lowerEnd 
	 * @param outputFile
	 */
	public ArrayList<Integer> quickSort(ArrayList<Integer> numbersToSort, int lowerEnd, int upperEnd)
	{
		if(lowerEnd < upperEnd)
		{
			/* get the pivot index and swap the value at pivot index with left position */
			int pivot = getPivot(numbersToSort, lowerEnd, upperEnd);
			
			Partition partition = new Partition();
			ArrayList<Integer> listOfNumbers = partition.partitionList(numbersToSort, lowerEnd, upperEnd, pivot);
			
			quickSort(listOfNumbers, partition.getEnd(), upperEnd);
			quickSort(listOfNumbers, lowerEnd, partition.getStart()-1);
		}
		
		return numbersToSort;
	}

	/**
	 * swap values at indexes in the list
	 * 
	 * @param list
	 * @param valueAtIndex1
	 * @param valueAtIndex2
	 */
	private void swap(ArrayList<Integer> list, int valueAtIndex1, int valueAtIndex2)
	{
		int temp = list.get(valueAtIndex1);
		list.set(valueAtIndex1, list.get(valueAtIndex2));
		list.set(valueAtIndex2, temp);
	}

	/**
	 * gets a pivot value by taking the median of 3 randomly chose values from the list
	 * @param numbersToSort
	 * @return the pivot value
	 */
	public int getPivot(ArrayList<Integer> numbersToSort, int lowerEnd, int upperEnd) 
	{
		int medianIndex = (upperEnd - lowerEnd)/2 + lowerEnd;
		ArrayList<Integer> threeValues = new ArrayList<Integer>();
		threeValues.add(numbersToSort.get(lowerEnd));
		threeValues.add(numbersToSort.get(medianIndex));
		threeValues.add(numbersToSort.get(upperEnd));
		
		/* sort the 3 values to have the medium index at position 1 between 0..2 */
		if(threeValues.get(0) > threeValues.get(1)) swap(threeValues, 0, 1);
		if(threeValues.get(1) > threeValues.get(2)) swap(threeValues, 1, 2);
		if(threeValues.get(0) > threeValues.get(1)) swap(threeValues, 0, 1);
		
		return threeValues.get(1);
	}
}
