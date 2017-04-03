import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import heapsort.HeapSorter;
import mergesort.MergeSorter;
import quicksort.QuickSorter;
import sharedClasses.Timer;

/**
 * 
 * @author Drew Rife
 * 
 * Implements Merge Sort, Quick Sort, and Heap Sort
 *
 */
public class Runner 
{
	private static Timer timer;
	public static ArrayList<String> directories;
	private static HashMap<String, ArrayList<Integer>> listOfNumbers;
	private static List<Timer> listOfTimes;
	private static final int numFilesPerDir = 30;
	
	/**
	 * main class to run
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		listOfTimes = new ArrayList<Timer>();
		fillListOfDirectories();
		generateFullFilePaths();
		
		for(String file : listOfNumbers.keySet())
		{
			recordQuickSortResults(file, listOfNumbers.get(file));
			recordMergeSortResults(file, listOfNumbers.get(file));
			recordHeapSortResults(file, listOfNumbers.get(file));
		}
	}

	/**
	 * creates a new timer object that runs and records the sorter specified in the constructor
	 * @param file
	 * @param numbersToSort
	 */
	private static void recordQuickSortResults(String file, ArrayList<Integer> numbersToSort) 
	{
		Timer timer = new Timer("QuickSort", file);
		timer.run(numbersToSort);
		listOfTimes.add(timer);
	}
	
	/**
	 * creates a new timer object that runs and records the sorter specified in the constructor
	 * @param file
	 * @param numbersToSort
	 */
	private static void recordMergeSortResults(String file, ArrayList<Integer> numbersToSort)
	{
		Timer timer = new Timer("MergeSort", file);
		timer.run(numbersToSort);
		listOfTimes.add(timer);
		System.out.println(timer.toString());
	}
	
	/**
	 * creates a new timer object that runs and records the sorter specified in the constructor
	 * @param file
	 * @param numbersToSort
	 */
	private static void recordHeapSortResults(String file, ArrayList<Integer> numbersToSort)
	{
		Timer timer = new Timer("HeapSort", file);
		timer.run(numbersToSort);
		listOfTimes.add(timer);
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
		ArrayList<Integer> numbersArray = new ArrayList<Integer>();
		int numberOfEntries;
		
		Scanner numbers = new Scanner(new File(file_path));
		
		for(int i = 0; numbers.hasNextLine(); i++)
		{
			numbersArray.add(Integer.parseInt(numbers.nextLine()));
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
