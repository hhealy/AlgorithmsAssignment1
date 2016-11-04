package assignment1;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.util.ArrayList;

public class BruteAutoCompleteTest 
{
	private BruteAutoComplete bruteAuto;
	private Term term5;
	private Term term35;
	private Term term100;
	private Term term156;
	private Term term7700;
	private ReadTerms terms;
	private ArrayList<String> results1;
	private ArrayList<String> results2;
	
	@Before
	public void setUp() throws IOException
	{
		terms = new ReadTerms();
		bruteAuto = new BruteAutoComplete();
		term5 = new Term(1742063600, "in");
		term35 = new Term(327769900, "my");
		term100 = new Term(92305300, "men");
		term156 = new Term(56467400, "get");
		term7700 = new Term(681404, "particles");
		
		results1 = new ArrayList<String>();//This creates an arraylist that contains the first three terms for 'in'
		results1.add(terms.terms.get(4).getTerm()); //adds the word "in"
		results1.add(terms.terms.get(55).getTerm()); //adds the word "into"
		results1.add(terms.terms.get(329).getTerm()); //add the word "indeed"
		
		results2 = new ArrayList<String>();//This creates an arraylist that contains the first six terms for 
		results2.add(terms.terms.get(2).getTerm()); //adds the word "and"
		results2.add(terms.terms.get(40).getTerm()); //adds the word "an"
		results2.add(terms.terms.get(57).getTerm()); //adds the word "any"
		results2.add(terms.terms.get(165).getTerm()); //adds the word "another"
		results2.add(terms.terms.get(292).getTerm()); //adds the word "anything"
		results2.add(terms.terms.get(340).getTerm()); //adds the word "answered"
	}
	
	@Test
	public void testWeightOf() //This tests the weightOf method by using the array of words and it gets the weight of each one.
	{
		assertEquals(1742063600, bruteAuto.weightOf("in"), 0.01);
		assertEquals(327769900, bruteAuto.weightOf("my"), 0.01);
		assertEquals(92305300, bruteAuto.weightOf("men"), 0.01);
		assertEquals(56467400, bruteAuto.weightOf("get"), 0.01);
		assertEquals(681404, bruteAuto.weightOf("particles"), 0.01);
	}
	
	@Test
	public void testFailedWeightOf()
	{
		assertEquals(0, bruteAuto.weightOf("FailureTest"), 0.01);
		assertEquals(0, bruteAuto.weightOf(""), 0.01);
	}
	
	@Test
	public void testBestMatch() //This tests the bestMatch method by using an array of of prefixes.
	{
		assertEquals(term5.getTerm(), bruteAuto.bestMatch("in"));
		assertEquals(term35.getTerm(), bruteAuto.bestMatch("my"));
		assertEquals(term100.getTerm(), bruteAuto.bestMatch("men"));
		assertEquals(term156.getTerm(), bruteAuto.bestMatch("get"));
		assertEquals(term7700.getTerm(), bruteAuto.bestMatch("particles"));
	}
	
	@Test
	public void testFailedBestMatch()
	{
		assertEquals(null, bruteAuto.bestMatch(null));
		assertEquals(null, bruteAuto.bestMatch("FailureTest"));
	}
	
	@Test
	public void testMatches() //This tests the matches method by getting the list of matches from the array.
	{
		assertEquals(results1, bruteAuto.matches("in", 3));
		assertEquals(results2, bruteAuto.matches("an", 6));
	}
	
	@Test
	public void testFailedMatches()
	{
		assertEquals(null, bruteAuto.matches(null, 1));
		assertEquals(null, bruteAuto.matches("FailureTest", 10000));
		assertEquals(null, bruteAuto.matches(null, 10000));
		assertEquals(null, bruteAuto.matches("in", -1));
	}
}
