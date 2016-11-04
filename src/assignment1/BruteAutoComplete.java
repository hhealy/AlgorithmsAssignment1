package assignment1;

import java.util.ArrayList;
import java.io.IOException;

public class BruteAutoComplete implements Autocomplete 
{
	ReadTerms terms;
	private ArrayList<String> result;
	
	public BruteAutoComplete() throws IOException
	{
		terms = new ReadTerms();
	}
	
	@Override
	public double weightOf(String term) 
	{
		if (term != null)
		{
			for (int i = 0; i < terms.terms.size(); i++)
			{
				if (term.equals(terms.terms.get(i).getTerm()))
					return terms.terms.get(i).getWeight();
			}
		}
		return 0;
	}

	@Override
	public String bestMatch(String prefix)
	{
		if (prefix != null)
		{
			for (int i = 0; i < terms.terms.size(); i++)
			{
				String comp = terms.terms.get(i).getTerm();
				if (comp.startsWith(prefix))
					return comp;
			}
		}
		return null;
	}

	@Override
	public Iterable<String> matches(String prefix, int k) 
	{
		result = new ArrayList<String>();
		
		if (prefix == null)
			return null;
		
		if (k < terms.terms.size())
		{
			for (int i = 0; result.size()<k && i<terms.terms.size(); i++)
			{
				String comp = terms.terms.get(i).getTerm();
				if (comp.startsWith(prefix) && result.size() < k)
					result.add(comp);
			}
		}
		
		if (result.size() == 0)
			return null;
		
		return result;
	}
}
