package edu.iastate.cs228.hw1;

/**
 * @author joey bingham
 */

public class Sequence
{
  protected char[] seqarr;
 
  /**
   * the constructor uses the isValidLetter method to check to see if the letters are kosher then
   * it instantiates the seqarr to the value passed in the form of a deep copy using clone.
   * @param 
   */
  public Sequence(char[] sarr)
  {
	
    // TODO
	  for( char ch : sarr){
		  if(!isValidLetter(ch)){
			  throw new IllegalArgumentException("Invalid sequence letter for class " + this.getClass());
		  }
	  }
	  seqarr = sarr.clone();
  }
  /**
   * this method returns the length using the Array.length method
   * @return 
   */
  public int seqLength()
  {
    // TODO
	  return seqarr.length;
  }
  /**
   * returns the sequence
   * @return
   */
  public char[] getSeq()
  {
    // TODO
	  return seqarr;
  }
  /**
   * creates a string from the char array
   */
  public String toString()
  {
    // TODO
	  String str = "";
	  for(char ch : seqarr){
		  str += Character.toUpperCase(ch); 
	  }
	  return str;
  }
  /**
   * checks to see if the sequences are equal and disregards case
   */
  public boolean equals(Object obj)
  { 
    // TODO
	  if( this == obj ) return true;
	  if( (obj == null) || (obj.getClass() != this.getClass() ) ) return false;  
	  Sequence test = (Sequence) obj;
	  return (test.toString().equals(this.toString()));
  }
	  
  /**
   * checks to see if the character is a letter
   * @param let
   * @return
   */

  public boolean isValidLetter(char let)
  {
    // TODO
	  return (Character.isLowerCase(let) || Character.isUpperCase(let));
}
}
