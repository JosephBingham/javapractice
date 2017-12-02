 package edu.iastate.cs228.hw2;

import java.util.Arrays;
import java.util.Comparator;
//@author Stroh Leslie
public class CustomComparator implements Comparator<String> {
        /***
         * Lookup table mapping characters in lexicographical order to
         * to their input order.
         */
	private CharacterValue[] characterOrdering;

        /***
         * Creates an array of CharacterValue from characterOrdering.  Sorts
         * it by character using Arrays.sort().
         * @param characterOrdering character order from configuration file
         */
	public CustomComparator(char[] characterOrdering) {
          //TODO
		for(int i = 0; i < characterOrdering.length; i++){
		this.characterOrdering[i] = new CharacterValue(i, characterOrdering[i]);
		}
		Arrays.sort(this.characterOrdering);
	}
        /***
         * Compares two words based on the configuration
         * @param a first word
         * @param b second word
         * @return negative if a<b, 0 if equal, postive if a>b
         */
	//@Override
	public int compare(String a, String b) {
		//TODO
		char[] a_arr = a.toCharArray();
		char[] b_arr = b.toCharArray();
		
		int n = Math.min(a_arr.length, b_arr.length);
		for(int i = 0; i < n ; i++){
			if(getCharacterOrdering(a_arr[i]) < getCharacterOrdering(b_arr[i])) return -1;
			if(getCharacterOrdering(a_arr[i]) > getCharacterOrdering(b_arr[i])) return 1;
			if(i == n-1 && a_arr.length != b_arr.length) return (a_arr.length == n) ? -1 : 1;
		}
        return 0;
	}
	
	/**
	 * Uses binary search to find the order of key.
	 * @param key
	 * @return ordering value for key or -1 if key is an invalid character.
	 */
	public int getCharacterOrdering(char key) {
		//TODO
		return binarySearch(characterOrdering, new CharacterValue(1,key));
	}
	
	/**
	 * Returns true if there are no invalid characters in string otherwise false
	 * @param array of strings
	 * @return true if all characters are valid
	 */
	public boolean validity(String word)
	{
			//TODO
			char[] chars = word.toCharArray();
			for(char d : chars){
				for(CharacterValue c : characterOrdering){
					if(c.character == d) break;
					if(c.character != d) return false;
			}
		}
			return true;
	}

	/**
	 * Searches characterOrdering for key via binary search
	 * @param characterOrdering the specified sort order
         * @param key the search term
	 * @return ordering value for key or -1 if key is an invalid character.
	 */
        private int binarySearch(CharacterValue[] characterOrdering, CharacterValue key) {
			//TODO
        	if(characterOrdering.length == 0 || characterOrdering == null) return -1;
        	else if(characterOrdering[characterOrdering.length/2].equals(key)) return characterOrdering[characterOrdering.length/2].value; 
			else if (characterOrdering[characterOrdering.length/2].character < key.character) 
				return binarySearch(Arrays.copyOfRange(characterOrdering, characterOrdering.length/2, characterOrdering.length),key);
			else
				return binarySearch(Arrays.copyOfRange(characterOrdering, 0, characterOrdering.length/2),key);
         }
		  
		  
	private static class CharacterValue  {
		public int value;
		public char character;
		
		public CharacterValue(int value, char character) {
			this.value = value;
			this.character = character;
		}
		
		public boolean equals(Object obj) {
			//TODO
			if(obj == this) return true;
			if(obj == null || obj.getClass() != this.getClass()) return false;
			CharacterValue nobj = (CharacterValue) obj;
			return ((this.value == nobj.value)&&(this.character == nobj.character));
		}

		
	}
	
	

}
