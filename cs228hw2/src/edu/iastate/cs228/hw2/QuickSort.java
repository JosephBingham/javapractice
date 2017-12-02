package edu.iastate.cs228.hw2;
import java.util.Comparator;
//@author Stroh Leslie
public class QuickSort extends SorterWithStatistics {
	//implement quick sort
	private String[] words;
	private int length;
	private CustomComparator comp;
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		 //TODO
		this.words = words;
		this.length = words.length;
		this.comp = (CustomComparator)comp;
		
		sort(this.words);
		
	}
	    public void sort(String[] inputArr) {
	         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.words = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = words[lowerIndex+(higherIndex-lowerIndex)/2].;
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which
	             * is greater then the pivot value, and also we will identify a number
	             * from right side which is less then the pivot value. Once the search
	             * is done, then we exchange both numbers.
	             */
	            while (words[i] < pivot) {
	                i++;
	            }
	            while (words[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        String temp = words[i];
	        words[i] = words[j];
	        words[j] = temp;
	    }
	
}
