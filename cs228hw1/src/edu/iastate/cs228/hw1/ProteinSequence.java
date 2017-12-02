package edu.iastate.cs228.hw1;

/**
 * @author joey bingham
*/

public class ProteinSequence extends Sequence
{
/**
 * uses the superclass constructor	
 * @param psarr
 */

  public ProteinSequence(char[] psarr)
  {
    // TODO
	  super(psarr);
	  
  }
/**
 * checks to see if the letter is not valid, and if it isn't, it returns true (confusing way to word it, but 
 * that's how the code is behaving)
 */
  @Override
  public boolean isValidLetter(char aa)
  {
    // TODO

	  boolean bool = !((aa=='B')||(aa=='b')||(aa=='J')||(aa=='j')||(aa=='O')||(aa=='o')||(aa=='U')||(aa=='u')||(aa=='X')||(aa=='x')||(aa=='Z')||(aa=='z'));
	  return (super.isValidLetter(aa) && bool);
  }
}
