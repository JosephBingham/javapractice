package edu.iastate.cs228.hw1;
import static org.junit.Assert.*;
import org.junit.*;
public class SequenceTest {

	//for whatever reason my @Before isn't working how I want it to, so I created all of the variables out here
		String goodString = "CTTCCATGCCGCCACCGCTGCAGATTGACGACGTCGTCTACGAAACTCAGATGGACAAGGC";  
		String sameAsGoodString = "CTTCCATGCCGCCACCGCTGCAGATTGACGACGTCGTCTACGAAACTCAGATGGACAAGGC".toLowerCase();
		String badString = "CTTCCATGCCGCCACCGCTDCAGATTGACGAC$$TCGTCTACGAAACTCAGATGGACAAGGC";
		int[] goodExons = {1, 3, 5, 7, 9, 14}; //should yield TTCATGCGCCAC
		int[] badExonsNeg = {-1, 3, 5, 7, 9, 14}; // checks negative
		int[] badExonsOrd = {3, 1, 5, 7, 9, 14}; // checks order
		int[] badExonsOdd = {1, 3, 5, 7, 9}; // checks odd
		int[] badExonsEmpty = {}; // checks empty
		int goodStringLength = goodString.length();
		Sequence s = new Sequence(goodString.toCharArray());
	
	@Test
	public void test_seqLength(){
		assertEquals(goodStringLength, s.seqLength());
	}
	@Test
	public void test_getSeq(){
		assert(goodString.toCharArray().equals(s.getSeq()));
	}
	@Test
	public void test_toString(){
		assertEquals(goodString, s.toString());
	}
	@Test
	public void test_equals(){
		Sequence t = new Sequence(sameAsGoodString.toCharArray());
		assert(s.equals(t));
	}
	@Test
	public void wanttofail_validLetterSeq(){
			Sequence bad = new Sequence(badString.toCharArray());
	}
	@Test
	public void wanttofail_validLetterDNA(){
			DNASequence dna = new DNASequence(badString.toCharArray());
	}
	@Test
	public void wanttofail_validLetterCoding(){
			CodingDNASequence cdna = new CodingDNASequence(badString.toCharArray());
	}
	@Test
	public void wanttofail_validLetterProtein(){
			ProteinSequence pdna = new ProteinSequence(badString.toCharArray());
	}
	@Test
	public void wanttofail_validLetterGenomic(){
		GenomicDNASequence gdna = new GenomicDNASequence(badString.toCharArray());
	}
	@Test
	public void test_checkStartCodon(){
		CodingDNASequence ncdna = new CodingDNASequence("ATG".toCharArray());
		assert(ncdna.checkStartCodon());
	}
	@Test
	public void wanttofail_checkStartCodon(){
		CodingDNASequence ncdna = new CodingDNASequence("fff".toCharArray());
		assert(ncdna.checkStartCodon());
	}
	@Test
	public void test_translate(){
		CodingDNASequence nncdna = new CodingDNASequence("AGTCACGAAGAACTT".toCharArray());
		char[] translated = nncdna.translate();
		char[] heel = {'M','H','E','E','L'};
		assert(translated.equals(heel));
	}
	@Test
	public void test_extractExons(){
		GenomicDNASequence goodExtract = new GenomicDNASequence(goodString.toCharArray());
		assert(goodExtract.extractExons(goodExons).equals("TTCATGCGCCAC".toCharArray()));		
	}
	@Test
	public void wanttofail_badExonsOrd(){
		GenomicDNASequence badExtract1 = new GenomicDNASequence(goodString.toCharArray());
		char[] wanttofail = badExtract1.extractExons(badExonsOrd);		
	}
	@Test
	public void wanttofail_badExonsOdd(){
		GenomicDNASequence badExtract1 = new GenomicDNASequence(goodString.toCharArray());
		char[] wanttofail = badExtract1.extractExons(badExonsOdd);		
	}
	@Test
	public void wanttofail_badExonsEmpty(){
		GenomicDNASequence badExtract1 = new GenomicDNASequence(goodString.toCharArray());
		char[] wanttofail = badExtract1.extractExons(badExonsEmpty);		
	}
	@Test
	public void wanttofail_badExonsNeg(){
		GenomicDNASequence badExtract1 = new GenomicDNASequence(goodString.toCharArray());
		char[] wanttofail = badExtract1.extractExons(badExonsNeg);		
	}
	
	
}
