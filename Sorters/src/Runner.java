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
	private static HashMap<String, ArrayList<Integer>> listOfNumbers;
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
			QuickSorter quickSorter = new QuickSorter();
			
			/* get the start index of the array and the end index */
			int startPosition = 0;
			int endPosition = listOfNumbers.get(key).size() -1;
			quickSorter.quickSort(listOfNumbers.get(key), startPosition, endPosition, "results.csv");
		}
	}

	/**
	 * reads from file and puts them in the listOfNumbers
	 * @throws FileNotFoundException 
	 */
	private static void generateFullFilePaths() throws FileNotFoundException 
	{
		listOfNumbers = new HashMap<String, ArrayList<Integer>>();
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
		listOfNumbers.put(file_path, new ArrayList<Integer>());
		Scanner numbers = new Scanner(new File(file_path));
		
		while(numbers.hasNextLine())
		{
			int number = Integer.parseInt(numbers.nextLine());
			listOfNumbers.get(file_path).add(number);
		}
		
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
