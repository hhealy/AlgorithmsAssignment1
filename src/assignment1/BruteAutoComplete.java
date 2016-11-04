package assignment1;

import java.util.ArrayList;
import java.io.IOException;

public class BruteAutoComplete implements Autocomplete 
{
	ReadTerms terms;
	private ArrayList<String> result; //Creates a new arraylist called result.
	
	public BruteAutoComplete() throws IOException
	{
		terms = new ReadTerms();
	}
	
	@Override
	public double weightOf(String term) 
	{
		if (term != null) //If the term is not equal to null, it enters the for loop, otherwise it will return 0.
		{
			for (int i = 0; i < terms.terms.size(); i++) //This for loop gets the weight of the term.
			{
				if (term.equals(terms.terms.get(i).getTerm())) 
					return terms.terms.get(i).getWeight(); //If the weight of the current term is equal to that of i, then both the name and wieght of the term are returned.
			}
		}
		return 0;
	}

	@Override
	public String bestMatch(String prefix)
	{
		if (prefix != null) //If the prefix is not null, it will enter the for loop to get the best match, otherwise null is returned.
		{
			for (int i = 0; i < terms.terms.size(); i++)
			{
				String comp = terms.terms.get(i).getTerm();
				if (comp.startsWith(prefix)) //If the string comp is equal to the term, it returns the string.
					return comp;
			}
		}
		return null;
	}

	@Override
	public Iterable<String> matches(String prefix, int k) 
	{
		result = new ArrayList<String>(); //Initialises the result arraylist
		
		if (prefix == null)
			return null;
		
		if (k < terms.terms.size()) 
		{
			for (int i = 0; result.size()<k && i<terms.terms.size(); i++)
			{
				String comp = terms.terms.get(i).getTerm(); 
				if (comp.startsWith(prefix) && result.size() < k) //If the string starts with the same prefix and it's smaller than k
					result.add(comp); //It will be added to the result arraylist.
			}
		}
		
		if (result.size() == 0)
			return null;
		
		return result; //Returns the arraylist of result.
	}
}
