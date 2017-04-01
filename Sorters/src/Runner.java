import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Drew Rife
 * 
 * Implements Merge Sort, Quick Sort, and Heap Sort
 *
 */
public class Runner 
{
	public static ArrayList<String> directories;
	private static HashMap<String, int[]> listOfNumbers;
	private static final int numFilesPerDir = 30;
	
	/**
	 * main class to run
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		
		
		fillListOfDirectories();
		generateFullFilePaths();
		
		for(String key : listOfNumbers.keySet())
		{
			if(key.contains("large_list/sorted_smallest_largest"))
			{
				/* get the start index of the array and the end index */
				int lowerEnd = 0;
				int upperEnd = listOfNumbers.get(key).length-1;
				
				System.out.println("Before: " + key);
				for(int i = 0; i < 20; i++)
				{
					System.out.print(listOfNumbers.get(key)[i] + ", ");
				}
				
				QuickSorter quickSorter = new QuickSorter();
				long startTime = System.nanoTime();
				quickSorter.quickSort(listOfNumbers.get(key), lowerEnd, upperEnd);
				long endTime = System.nanoTime();
				long duration = endTime-startTime;
				
				System.out.print("\nDuration (ns): " + duration);
				System.out.println("\nAfter: ");
				for(int i = 0; i < 20; i++)
				{
					System.out.print(listOfNumbers.get(key)[i] + ", ");
				}
				
				System.out.println("\n\n");
				
			}
				
				
		}
	}

	/**
	 * reads from file and puts them in the listOfNumbers
	 * @throws FileNotFoundException 
	 */
	private static void generateFullFilePaths() throws FileNotFoundException 
	{
		listOfNumbers = new HashMap<String, int[]>();
		for(String dir : directories)
		{
			for(int fileNum = 1; fileNum <= numFilesPerDir; fileNum++)
			{
				String file_path = dir;
				
				if(file_path.contains("unsorted"))
				{
					file_path += "unsorted_";
				}
				else 
				{
					file_path += "sorted_";
				}
				
				file_path += Integer.toString(fileNum);
				file_path += ".txt";
			
				readFromFiles(file_path, dir);
			}
		}
	}

	/**
	 * reads from text files and puts them in a list in a HashMap identified by their file path as key
	 * @param file_path
	 * @throws FileNotFoundException 
	 */
	private static void readFromFiles(String file_path, String dir) throws FileNotFoundException 
	{
		int[] numbersArray;
		int numberOfEntries;
		
		if(file_path.contains("small_list"))
		{
			numberOfEntries = 10000;
			numbersArray = new int[numberOfEntries];
		}
		else if(file_path.contains("medium_list"))
		{
			numberOfEntries = 100000;
			numbersArray = new int[numberOfEntries];
		}
		else 
		{
			numberOfEntries = 1000000;
			numbersArray = new int[numberOfEntries];
		}

		Scanner numbers = new Scanner(new File(file_path));
		
		for(int i = 0; numbers.hasNextLine(); i++)
		{
			numbersArray[i] = Integer.parseInt(numbers.nextLine());
		}
		
		listOfNumbers.put(file_path, numbersArray);
		
		numbers.close();
	}

	/**
	 * fills the directories list of known directories with text files for sorting
	 */
	private static void fillListOfDirectories()
	{
		directories = new ArrayList<String>();
		directories.add("text_files/small_list/unsorted/");
		directories.add("text_files/small_list/sorted_smallest_largest/");
		directories.add("text_files/small_list/sorted_largest_smallest/");
		
		directories.add("text_files/medium_list/unsorted/");
		directories.add("text_files/medium_list/sorted_smallest_largest/");
		directories.add("text_files/medium_list/sorted_largest_smallest/");
		
		directories.add("text_files/large_list/unsorted/");
		directories.add("text_files/large_list/sorted_smallest_largest/");
		directories.add("text_files/large_list/sorted_largest_smallest/");
	}
}
