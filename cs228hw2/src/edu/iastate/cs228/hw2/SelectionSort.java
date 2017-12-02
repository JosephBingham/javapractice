package edu.iastate.cs228.hw2;

import java.util.Arrays;
import java.util.Comparator;
//@author Stroh Leslie

public class SelectionSort extends SorterWithStatistics {
	//implement selection sort
	CustomComparator comp;
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		//TODO
		this.comp = (CustomComparator)comp; 
		for(int i = 0; i < words.length; i++){
			swap(i, findmin(i, words), words);
		}	
	}
	private int findmin(int i, String[] words){
	
		int min = 0;
		for(int j = i; i < words.length ; j++){
			if(comp.compare(words[min],words[j]) > 0){
				min = j;
			}
		}
		return min;
	}
	private void swap(int index1, int index2, String[] words){
		String word1 = words[index1];
		words[index1] = words[index2];
		words[index2] = word1;
	}
}
