/*
 * Henry Healy
 * 20072447
 * Applied Computing
 * 2nd Year
 * Frank Walsh
*/
package assignment1;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;

public class ReadTermsTest 
{
	private ReadTerms terms;
	private Term term5;
	private Term term35;
	private Term term100;
	private Term term156;
	private Term term7700;
	
	@Before
	public void setUp() throws IOException
	{
		terms = new ReadTerms();
		term5 = new Term(1742063600, "in");
		term35 = new Term(327769900, "my");
		term100 = new Term(92305300, "men");
		term156 = new Term(56467400, "get");
		term7700 = new Term(681404, "particles");
	}
	
	//Tests 5 different terms from the list of 10,000 words to make sure their weights and terms are as they are expected.
	@Test
	public void testBuildList()
	{
		assertEquals(terms.terms.get(4).getWeight(), term5.getWeight(), 0.01);
		assertEquals(terms.terms.get(4).getTerm(), term5.getTerm());
		assertEquals(terms.terms.get(34).getWeight(), term35.getWeight(), 0.01);
		assertEquals(terms.terms.get(34).getTerm(), term35.getTerm());
		assertEquals(terms.terms.get(99).getWeight(), term100.getWeight(), 0.01);
		assertEquals(terms.terms.get(99).getTerm(), term100.getTerm());
		assertEquals(terms.terms.get(155).getWeight(), term156.getWeight(), 0.01);
		assertEquals(terms.terms.get(155).getTerm(), term156.getTerm());
		assertEquals(terms.terms.get(7699).getWeight(), term7700.getWeight(), 0.01);
		assertEquals(terms.terms.get(7699).getTerm(), term7700.getTerm());
	}
	
	//This test tests to make sure the size of the list is 10,000 terms long.
	@Test
	public void testSize()
	{
		assertEquals(terms.terms.size(), 10000);
	}
}
