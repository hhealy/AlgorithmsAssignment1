package assignment1;

import java.io.IOException;
import java.util.Scanner;

public class Driver
{
	private Scanner input;
	private BruteAutoComplete bruteAuto;

	public Driver()
	{
		input = new Scanner(System.in);
	}

	public static void main(String [] args) throws IOException
	{
		Driver driver = new Driver();
		driver.runMainMenu();
	}

	private int mainMenu()
	{
		System.out.println("Please choose a program: ");
		System.out.println("--------");
		System.out.println("1) BruteAutoComplete");
		System.out.println("2) QuickAutoComplete");
		System.out.println("0) Exit");
		System.out.println("--------");
		int option = input.nextInt();
		return option;
	}

	private void runMainMenu() throws IOException
	{
		int option = mainMenu();
		switch (option)
		{
			case 1: 
				bruteAutoCompleteSearch();
				break;
			case 2:
				quickAutoCompleteSearch();
				break;
			case 0:
				System.out.println("Exiting system");
				System.exit(0);
		}
	}

	private void bruteAutoCompleteSearch() throws IOException
	{
		bruteAuto = new BruteAutoComplete();
		
		System.out.println("Please enter a string: ");
		System.out.println("---->");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("How many matches would you like?: ");
		System.out.println("---->");
		int k = input.nextInt();
		System.out.println(bruteAuto.matches(prefix, k));
	}

	private void quickAutoCompleteSearch() throws IOException
	{
		System.out.println("Not yet configured");
	}
}