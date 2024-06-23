package lab1;

import java.util.Scanner;

public class DrivingVoting 
{
	public static void main(String[] args) 
	{	
		try
		{
			try (Scanner keyboard = new Scanner (System.in)) {
				System.out.print("Enter your age: ");
				int age = keyboard.nextInt();

				if (age > 120 || age < 0)
				{
					System.out.println("Sorry, invalid age. Please enter an age between 0-120.");
					System.exit(0);
				}
				
				if (age > 18)
				{
					System.out.println("Hurray, you can drive and vote!");
				}
				
				if (age < 18 && age > 16)
				{
					System.out.println("Hurray, you can drive! However, you have to wait " + (18-age) + " year(s) until you can vote!");
				}
				
				if (age < 16)
				{
					System.out.println("Sorry, you must wait " + (16-age) + " year(s) until you can drive and " + (18-age) + " year(s) until you can vote!");
				}
			}

		}
		catch (Exception e)
		{
			System.out.println("Sorry, invalid age. Please enter an age between 0-120.");
			System.exit(0);
		}
	}
}
