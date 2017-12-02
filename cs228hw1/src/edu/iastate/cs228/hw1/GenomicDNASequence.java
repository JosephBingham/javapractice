package edu.iastate.cs228.hw1;

/**
 * @author joey bingham
*/

public class GenomicDNASequence extends DNASequence
{
  public GenomicDNASequence(char[] gdnaarr)
  {
    // TODO
	  super(gdnaarr);
  }
  /**
   * the method takes all the coding exons specified by
   * the array exonpos, concatenates them in order, and returns the resulting sequence in a
   * new character array. Note that the array length is the length of the resulting sequence.
   */
  

  public char[] extractExons(int[] exonpos)
  {
    // TODO

	  	for(int i = 0; i < exonpos.length - 1; i++){
	  		if(exonpos[i]<0 ||seqarr.length<exonpos[i]){
	  			throw new IllegalArgumentException("Exon position is out of bound");
	  		}else if(exonpos[i+1]<exonpos[i]){
	  			throw new IllegalArgumentException("Exon positions are not in order");
	  		}
	  	}
	  if(exonpos.length == 0 || (exonpos.length + 1)%2 == 0){
		  throw new IllegalArgumentException("“Empty array or odd number of array elements");
	  }
	  else{
		  
		  String exons = "";
		  for(int i = 0; i < exonpos.length/2; i++){
			  String str = "";
			  int n = exonpos[i*2];
			  while(n<=exonpos[(i*2)+1]){
				  str += seqarr[n++];
			  }
			  exons += str;
		  }
		  	  return exons.toCharArray();
	  }
  }

}
