import java.util.ArrayList;

/**
 * Swapper class for swapping values
 * 
 * @author drew
 *
 */
public class Swapper 
{
	public static void swap(ArrayList<Integer> listOfNumbers, int index1, int index2)
	{
		int temp = listOfNumbers.get(index1);
		listOfNumbers.set(index1, listOfNumbers.get(index2));
		listOfNumbers.set(index2, temp);
	}
}
