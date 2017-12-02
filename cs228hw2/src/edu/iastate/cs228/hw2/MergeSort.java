package edu.iastate.cs228.hw2;

//@author Stroh Leslie
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort extends SorterWithStatistics {
	// Implement merge sort
	CustomComparator comp;

	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		// TODO
		this.comp = (CustomComparator) comp;
		words = getSorted(words);

	}

	private String[] getSorted(String[] words) {
		if (words.length < 2)
			return words;
		else {
			return merge(Arrays.copyOfRange(words, 0, words.length / 2),
					Arrays.copyOfRange(words, words.length / 2, words.length));
		}
	}

	private String[] merge(String[] ar1, String[] ar2) {
		String[] returned = new String[ar1.length + ar2.length];
		int i = 0;
		for (String a : ar1) {
			for (String b : ar2) {
				if (comp.compare(a, b) == 0) {
					returned[i++] = a;
					continue;
				}
				if (comp.compare(a, b) < 1) {
					returned[i++] = a;
					continue;
				} else {
					returned[i++] = b;
					continue;
				}
			}
		}
		return returned;
	}
}
