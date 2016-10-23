package assignment1;

public class Term 
{
	private double weight;
	private String term;
	
	public Term(double weight, String term)
	{
		this.weight = weight;
		this.term = term;
	}
	
	//Getters
	public String getTerm()
	{
		return term;
	}
	
	public double getWeight()
	{
		return weight;
	}
}
