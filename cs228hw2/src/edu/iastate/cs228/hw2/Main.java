package edu.iastate.cs228.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//@author Stroh Leslie
public class Main {
	
	//All exceptions should be handled in main
	public static void main(String args[]) {
        //TODO
		//This is where you should run your experiments with SorterWithStatistics class on the different sort methods
		//as stated in the pdf. Any thrown exceptions should be caught here. 
		
	}

	/**
	 * Reads the characters contained in filename and returns them as a character array.
	 * @param filename the file containing the list of characters
	 * @returns an char array representing the ordering of characters to be used 
	 *  or null if there is a FileNotFoundException. Should throw a FileConfigurationException
	 *  if the file is invalid.
	 */

	public static char[] readCharacterOrdering(String filename) {
			//TODO
			File file = new File(filename);
			
			return null;			
	}
	
	/**
	 * Reads the words from the file and returns them as a String array.
	 * @param filename file containing words
	 * @return the words contained in the file or null if there was a FileNotFoundException.
	   Should throw a FileConfigurationException if the file is invalid.
	 */
	public static String[] readWordsFile(String filename, CustomComparator comp){
		    //TODO
			return null;	
	}
	
	/**
	 * Returns whether or not word is valid.
	 * @param word word to be checked.
	 * @param comparator comparator used to check if characters are valid.
	 * @return
	 */
	public static boolean isValid(String word, CustomComparator comparator) {
		  //TODO
          return true;
	}
	
	private static class FileConfigurationException extends Exception {
	    
	      public  FileConfigurationException(String message)
	      {
	    	  super(message);
	      }
	
	}

	
}
