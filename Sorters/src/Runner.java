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
import sharedClasses.TimeContainer;

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
	private static List<TimeContainer> listOfTimes;
	private static final int numFilesPerDir = 30;
	
	/**
	 * main class to run
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		listOfTimes = new ArrayList<TimeContainer>();
		fillListOfDirectories();
		generateFullFilePaths();
		
		for(String file : listOfNumbers.keySet())
		{
//			doQuickSort(file, listOfNumbers.get(file));
//			doMergeSort(file, listOfNumbers.get(file));
			doHeapSort(file, listOfNumbers.get(file));
		}
	}

	/**
	 * does the heapsort algorithm
	 * 
	 * @param file
	 * @param arrayList
	 */
	private static void doHeapSort(String file, ArrayList<Integer> numbersToSort) 
	{
		String algorithm = "HeapSort";
		int[] listToSort = numbersToSort.stream().mapToInt(i -> i).toArray();
		System.out.println("\n\n\n");
		for(int i = 0; i < 20; i++)
		{
			System.out.print(listToSort[i] + ", ");
		}
		
		HeapSorter heapSorter = new HeapSorter();
		listToSort = heapSorter.heapSort(listToSort);
		
		System.out.println("\nAfter:");
		for(int i = 0; i < 20; i++)
		{
			System.out.print(listToSort[i] + ", ");
		}
		
	}

	/**
	 * does the mergesort algorithm
	 *  
	 * @param file
	 * @param arrayList
	 */
	private static void doMergeSort(String file, ArrayList<Integer> numbersToSort) 
	{
		String algorithm = "MergeSort";
		int[] listToSort = numbersToSort.stream().mapToInt(i -> i).toArray();
		System.out.println("\n\n\n");
		for(int i = 0; i < 20; i++)
		{
			System.out.print(listToSort[i] + ", ");
		}
		
		MergeSorter mergeSort = new MergeSorter();
		mergeSort.sort(listToSort);
	}

	/**
	 * does the quicksort algorithm
	 * 
	 * @param file
	 * @param arrayList
	 */
	private static void doQuickSort(String file, ArrayList<Integer> numbersToSort) 
	{
		String algorithm = "QuickSort";
		int lowerEnd = 0;
		int upperEnd = numbersToSort.size()-1;
		
		QuickSorter quickSorter = new QuickSorter();
		
		double startTime = System.currentTimeMillis();
		quickSorter.quickSort(numbersToSort, lowerEnd, upperEnd);
		double endTime = System.currentTimeMillis();
		double duration = endTime - startTime;
		
		TimeContainer timeContainer = new TimeContainer(algorithm, file, duration);
		listOfTimes.add(timeContainer);
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
