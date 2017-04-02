import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import quicksort.QuickSorter;

/**
 * Tests quicksorter class
 * 
 * @author drew
 *
 */
public class TestQuickSorter 
{
	
	@Test
	public void testQuickSortMethod()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(700);
		array.add(300);
		array.add(400);
		array.add(600);
		array.add(700);
		array.add(450);
		array.add(502);
		
		int lowerEnd = 0;
		int upperEnd = array.size()-1;
		
		System.out.println("Before: " );
		for(Integer number : array)
		{
			System.out.print(number + ", ");
		}
		
		QuickSorter quickSorter = new QuickSorter();
		long startTime = System.nanoTime();
		quickSorter.quickSort(array, lowerEnd, upperEnd);
		long endTime = System.nanoTime();
		long duration = endTime-startTime;
		
		System.out.println("\nDuration (ns): " + duration);
		System.out.println("\nAfter: ");
		for(Integer number : array)
		{
			System.out.print(number + ", ");
		}
		
		System.out.println("\n\n");
		
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2 = array;
		Collections.sort(array2);
		
		for(int i = 0; i < array2.size(); i++)
		{
			assertEquals(array2.get(i), array.get(i));
		}
		
	}

}
