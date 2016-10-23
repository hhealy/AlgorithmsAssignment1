package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadTerms 
{
	private static final String url = "https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt";
	public List<Term> terms = new ArrayList<Term>();
	
	public ReadTerms() throws IOException
	{
		buildList();
	}
	
	private void buildList() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
		String inputLine;
		String term;
		double weight;
		//This causes the BufferedReader to treat every tab space as a new line, separating terms and weights.
		String delimiter = "	";
		//This line causes BufferedReader to skip the first line.
		in.readLine();
		inputLine = null;
		while ((inputLine = in.readLine()) != null)
		{
			//This creates an Array of String and implements the delimiter.
			String[] termList = inputLine.split(delimiter);
			
			weight = Double.parseDouble(termList[0]);
			term = termList[1];
			terms.add(new Term(weight, term));
		}
		if (in != null)
		{
			in.close();
		}
	}
}
