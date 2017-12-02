package edu.iastate.cs228.hw2;
import java.util.Comparator;
//@author Stroh Leslie
public abstract class SorterWithStatistics implements Sorter {
	private Stopwatch timer = new Stopwatch();
	
        /***
         * Default constructor
         */
	public SorterWithStatistics() 
	{
         
	}

        /***
         * Public interface to sortHelper that keeps track of performance
         * statistics, including counting words sorted and timing sort
         * instances.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
         */
	public void sort(String[] words, Comparator<String> comp) {
		 //TODO
		
	}
	
	/**
	 * Sorts the array words.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
	 */
	protected abstract void sortHelper(String[] words, Comparator<String> comp);

	/**
	 * Returns number of words sorted in last sort.  Throws IllegalStateException if nothing has been sorted.
	 * @return number of words sorted in last sort.
	 */
	public int getWordsSorted() {
		 //TODO
		 return 0;
	}
	
	/**
	 * Returns time the last sort took.  Throws IllegalStateException if nothing has been sorted.
	 * @return time last sort took.
	 */
	public long getTimeToSortWords() {
		 //TODO
		 return 0;
          
	}
	
	/**
	 * Returns total words sorted by this instance.
	 * @return total number of words sorted.
	 */
	public int getTotalWordsSorted() {
          //TODO
		  return 0;
	}
	
	/**
	 * Returns the total amount of time spent sorting by this instance.
	 * @return total time spent sorting.
	 */
	public long getTotalTimeToSortWords() {
          //TODO
		  return 0;
	}
}
