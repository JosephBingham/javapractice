package edu.iastate.cs228.hw1;

/*
 * @author joey bingham
*/
public class DNASequence extends Sequence
{
	public final char[] good = {'a', 'A', 'c', 'C', 'g', 'G', 't', 'T'}; 
 
/**
 * uses the superclass constructor
 * @param dnaarr
 */
  public DNASequence(char[] dnaarr)
  {
    // TODO  
	  super(dnaarr);
	    
  }
/**
 * checks to see if the letter is in the exceptable list
 * returns false if it isn't
 */
  @Override
  public boolean isValidLetter(char let)
  {
    // TODO
	return((let=='a')||(let=='A')||(let=='c')||(let=='C')||(let=='g')||(let=='G')||(let=='t')||(let=='T'));
	
  }

}
