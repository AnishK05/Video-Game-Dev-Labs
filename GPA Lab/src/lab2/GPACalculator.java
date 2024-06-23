package lab2;

import java.util.Scanner;

public class GPACalculator 
{
	public static void main(String[] args) 
	{
		double totalGPA = 0;
		try (Scanner keyboard = new Scanner (System.in)) {
			System.out.print("Enter Course 1 Level: ");
			int courseLevel1 = keyboard.nextInt();
			
			if  (courseLevel1 > 4 || courseLevel1 < 1) 
			{
				System.out.println("Incorrect course level entered! Please enter a value from 1-4.");
				System.exit(0);
			}
			
			System.out.print("Enter Course 1 grade: ");
			int courseGrade1 = keyboard.nextInt();
			
			if (courseGrade1 > 100 || courseGrade1 < 70)
			{
				System.out.println("Incorrect course grade entered! Please enter a grade from 70-100.");
				System.exit(0);
			}
			
			if (courseLevel1 == 4)
			{
				if (courseGrade1 >= 97)
					totalGPA += 6.0;
				else if (courseGrade1 >= 94)
					totalGPA +=5.8;
				else if (courseGrade1 >= 90)
					totalGPA += 5.6;
				else if (courseGrade1 >= 87)
					totalGPA +=5.4;
				else if (courseGrade1 >= 84)
					totalGPA +=5.2;
				else if (courseGrade1 >= 80)
					totalGPA +=5.0;
				else if (courseGrade1 >= 77)
					totalGPA += 4.8;
				else if (courseGrade1 >= 74)
					totalGPA += 4.6;
				else if (courseGrade1 >= 71)
					totalGPA +=4.4;
				else
					totalGPA +=4.0;
			}
			
			if (courseLevel1 == 3)
			{
				if (courseGrade1 >= 97)
					totalGPA += 5.5;
				else if (courseGrade1 >= 94)
					totalGPA +=5.3;
				else if (courseGrade1 >= 90)
					totalGPA += 5.1;
				else if (courseGrade1 >= 87)
					totalGPA +=4.9;
				else if (courseGrade1 >= 84)
					totalGPA +=4.7;
				else if (courseGrade1 >= 80)
					totalGPA +=4.5;
				else if (courseGrade1 >= 77)
					totalGPA += 4.3;
				else if (courseGrade1 >= 74)
					totalGPA += 4.1;
				else if (courseGrade1 >= 71)
					totalGPA +=3.9;
				else
					totalGPA +=3.7;
			}
			
			if (courseLevel1 == 2)
			{
				if (courseGrade1 >= 97)
					totalGPA +=5.0;
				else if (courseGrade1 >= 94)
					totalGPA +=4.8;
				else if (courseGrade1 >= 90)
					totalGPA +=4.6;
				else if (courseGrade1 >= 87)
					totalGPA +=4.4;
				else if (courseGrade1 >= 84)
					totalGPA +=4.2;
				else if (courseGrade1 >= 80)
					totalGPA +=4.0;
				else if (courseGrade1 >= 77)
					totalGPA +=3.8;
				else if (courseGrade1 >= 74)
					totalGPA +=3.6;
				else if (courseGrade1 >= 71)
					totalGPA +=3.4;
				else
					totalGPA +=3.2;
			}
			
			if (courseLevel1 == 1)
			{
				if (courseGrade1 >= 97)
					totalGPA += 4.0;
				else if (courseGrade1 >= 94)
					totalGPA +=3.8;
				else if (courseGrade1 >= 90)
					totalGPA +=3.6;
				else if (courseGrade1 >= 87)
					totalGPA +=3.4;
				else if (courseGrade1 >= 84)
					totalGPA +=3.2;
				else if (courseGrade1 >= 80)
					totalGPA +=3.0;
				else if (courseGrade1 >= 77)
					totalGPA +=2.8;
				else if (courseGrade1 >= 74)
					totalGPA +=2.6;
				else if (courseGrade1 >= 71)
					totalGPA +=2.4;
				else
					totalGPA +=2.2;
			}
			
			System.out.print("Enter Course 2 Level: ");
			int courseLevel2 = keyboard.nextInt();
			
			if  (courseLevel2 > 4 || courseLevel2 < 1) 
			{
				System.out.println("Incorrect course level entered! Please enter a value from 1-4.");
				System.exit(0);
			}
			
			System.out.print("Enter Course 2 grade: ");
			int courseGrade2 = keyboard.nextInt();
			
			if (courseGrade2 > 100 || courseGrade2 < 70)
			{
				System.out.println("Incorrect course grade entered! Please enter a grade from 70-100.");
				System.exit(0);
			}
			
			if (courseLevel2 == 4)
			{
				if (courseGrade2 >= 97)
					totalGPA += 6.0;
				else if (courseGrade2 >= 94)
					totalGPA +=5.8;
				else if (courseGrade2 >= 90)
					totalGPA += 5.6;
				else if (courseGrade2 >= 87)
					totalGPA +=5.4;
				else if (courseGrade2 >= 84)
					totalGPA +=5.2;
				else if (courseGrade2 >= 80)
					totalGPA +=5.0;
				else if (courseGrade2 >= 77)
					totalGPA += 4.8;
				else if (courseGrade2 >= 74)
					totalGPA += 4.6;
				else if (courseGrade2 >= 71)
					totalGPA +=4.4;
				else
					totalGPA +=4.0;
			}
			
			if (courseLevel2 == 3)
			{
				if (courseGrade2 >= 97)
					totalGPA += 5.5;
				else if (courseGrade2 >= 94)
					totalGPA +=5.3;
				else if (courseGrade2 >= 90)
					totalGPA += 5.1;
				else if (courseGrade2 >= 87)
					totalGPA +=4.9;
				else if (courseGrade2 >= 84)
					totalGPA +=4.7;
				else if (courseGrade2 >= 80)
					totalGPA +=4.5;
				else if (courseGrade2 >= 77)
					totalGPA += 4.3;
				else if (courseGrade2 >= 74)
					totalGPA += 4.1;
				else if (courseGrade2 >= 71)
					totalGPA +=3.9;
				else
					totalGPA +=3.7;
			}
			
			if (courseLevel2 == 2)
			{
				if (courseGrade2 >= 97)
					totalGPA +=5.0;
				else if (courseGrade2 >= 94)
					totalGPA +=4.8;
				else if (courseGrade2 >= 90)
					totalGPA +=4.6;
				else if (courseGrade2 >= 87)
					totalGPA +=4.4;
				else if (courseGrade2 >= 84)
					totalGPA +=4.2;
				else if (courseGrade2 >= 80)
					totalGPA +=4.0;
				else if (courseGrade2 >= 77)
					totalGPA +=3.8;
				else if (courseGrade2 >= 74)
					totalGPA +=3.6;
				else if (courseGrade2 >= 71)
					totalGPA +=3.4;
				else
					totalGPA +=3.2;
			}
			
			if (courseLevel2 == 1)
			{
				if (courseGrade2 >= 97)
					totalGPA += 4.0;
				else if (courseGrade2 >= 94)
					totalGPA +=3.8;
				else if (courseGrade2 >= 90)
					totalGPA +=3.6;
				else if (courseGrade2 >= 87)
					totalGPA +=3.4;
				else if (courseGrade2 >= 84)
					totalGPA +=3.2;
				else if (courseGrade2 >= 80)
					totalGPA +=3.0;
				else if (courseGrade2 >= 77)
					totalGPA +=2.8;
				else if (courseGrade2 >= 74)
					totalGPA +=2.6;
				else if (courseGrade2 >= 71)
					totalGPA +=2.4;
				else
					totalGPA +=2.2;
			}
			
			System.out.print("Enter Course 3 Level: ");
			int courseLevel3 = keyboard.nextInt();
			
			if  (courseLevel3 > 4 || courseLevel3 < 1) 
			{
				System.out.println("Incorrect course level entered! Please enter a value from 1-4.");
				System.exit(0);
			}

			System.out.print("Enter Course 3 grade: ");
			int courseGrade3 = keyboard.nextInt();
			
			if (courseGrade3 > 100 || courseGrade3 < 70)
			{
				System.out.println("Incorrect course grade entered! Please enter a grade from 70-100.");
				System.exit(0);
			}
			
			if (courseLevel3 == 4)
			{
				if (courseGrade3 >= 97)
					totalGPA += 6.0;
				else if (courseGrade3 >= 94)
					totalGPA +=5.8;
				else if (courseGrade3 >= 90)
					totalGPA += 5.6;
				else if (courseGrade3 >= 87)
					totalGPA +=5.4;
				else if (courseGrade3 >= 84)
					totalGPA +=5.2;
				else if (courseGrade3 >= 80)
					totalGPA +=5.0;
				else if (courseGrade3 >= 77)
					totalGPA += 4.8;
				else if (courseGrade3 >= 74)
					totalGPA += 4.6;
				else if (courseGrade3 >= 71)
					totalGPA +=4.4;
				else
					totalGPA +=4.0;
			}
			
			if (courseLevel3 == 3)
			{
				if (courseGrade3 >= 97)
					totalGPA += 5.5;
				else if (courseGrade3 >= 94)
					totalGPA +=5.3;
				else if (courseGrade3 >= 90)
					totalGPA += 5.1;
				else if (courseGrade3 >= 87)
					totalGPA +=4.9;
				else if (courseGrade3 >= 84)
					totalGPA +=4.7;
				else if (courseGrade3 >= 80)
					totalGPA +=4.5;
				else if (courseGrade3 >= 77)
					totalGPA += 4.3;
				else if (courseGrade3 >= 74)
					totalGPA += 4.1;
				else if (courseGrade3 >= 71)
					totalGPA +=3.9;
				else
					totalGPA +=3.7;
			}
			
			if (courseLevel3 == 2)
			{
				if (courseGrade3 >= 97)
					totalGPA +=5.0;
				else if (courseGrade3 >= 94)
					totalGPA +=4.8;
				else if (courseGrade3 >= 90)
					totalGPA +=4.6;
				else if (courseGrade3 >= 87)
					totalGPA +=4.4;
				else if (courseGrade3 >= 84)
					totalGPA +=4.2;
				else if (courseGrade3 >= 80)
					totalGPA +=4.0;
				else if (courseGrade3 >= 77)
					totalGPA +=3.8;
				else if (courseGrade3 >= 74)
					totalGPA +=3.6;
				else if (courseGrade3 >= 71)
					totalGPA +=3.4;
				else
					totalGPA +=3.2;
			}
			
			if (courseLevel3 == 1)
			{
				if (courseGrade3 >= 97)
					totalGPA += 4.0;
				else if (courseGrade3 >= 94)
					totalGPA +=3.8;
				else if (courseGrade3 >= 90)
					totalGPA +=3.6;
				else if (courseGrade3 >= 87)
					totalGPA +=3.4;
				else if (courseGrade3 >= 84)
					totalGPA +=3.2;
				else if (courseGrade3 >= 80)
					totalGPA +=3.0;
				else if (courseGrade3 >= 77)
					totalGPA +=2.8;
				else if (courseGrade3 >= 74)
					totalGPA +=2.6;
				else if (courseGrade3 >= 71)
					totalGPA +=2.4;
				else
					totalGPA +=2.2;
			}
			
			System.out.print("Enter Course 4 Level: ");
			int courseLevel4 = keyboard.nextInt();
			
			if  (courseLevel4 > 4 || courseLevel4 < 1) 
			{
				System.out.println("Incorrect course level entered! Please enter a value from 1-4.");
				System.exit(0);
			}
			
			System.out.print("Enter Course 4 grade: ");
			int courseGrade4 = keyboard.nextInt();
			
			if (courseGrade4 > 100 || courseGrade4 < 70)
			{
				System.out.println("Incorrect course grade entered! Please enter a grade from 70-100.");
				System.exit(0);
			}
			
			if (courseLevel4 == 4)
			{
				if (courseGrade4 >= 97)
					totalGPA += 6.0;
				else if (courseGrade4 >= 94)
					totalGPA +=5.8;
				else if (courseGrade4 >= 90)
					totalGPA += 5.6;
				else if (courseGrade4 >= 87)
					totalGPA +=5.4;
				else if (courseGrade4 >= 84)
					totalGPA +=5.2;
				else if (courseGrade4 >= 80)
					totalGPA +=5.0;
				else if (courseGrade4 >= 77)
					totalGPA += 4.8;
				else if (courseGrade4 >= 74)
					totalGPA += 4.6;
				else if (courseGrade4 >= 71)
					totalGPA +=4.4;
				else
					totalGPA +=4.0;
			}
			
			if (courseLevel4 == 3)
			{
				if (courseGrade4 >= 97)
					totalGPA += 5.5;
				else if (courseGrade4 >= 94)
					totalGPA +=5.3;
				else if (courseGrade4 >= 90)
					totalGPA += 5.1;
				else if (courseGrade4 >= 87)
					totalGPA +=4.9;
				else if (courseGrade4 >= 84)
					totalGPA +=4.7;
				else if (courseGrade4 >= 80)
					totalGPA +=4.5;
				else if (courseGrade4 >= 77)
					totalGPA += 4.3;
				else if (courseGrade4 >= 74)
					totalGPA += 4.1;
				else if (courseGrade4 >= 71)
					totalGPA +=3.9;
				else
					totalGPA +=3.7;
			}
			
			if (courseLevel4 == 2)
			{
				if (courseGrade4 >= 97)
					totalGPA +=5.0;
				else if (courseGrade4 >= 94)
					totalGPA +=4.8;
				else if (courseGrade4 >= 90)
					totalGPA +=4.6;
				else if (courseGrade4 >= 87)
					totalGPA +=4.4;
				else if (courseGrade4 >= 84)
					totalGPA +=4.2;
				else if (courseGrade4 >= 80)
					totalGPA +=4.0;
				else if (courseGrade4 >= 77)
					totalGPA +=3.8;
				else if (courseGrade4 >= 74)
					totalGPA +=3.6;
				else if (courseGrade4 >= 71)
					totalGPA +=3.4;
				else
					totalGPA +=3.2;
			}
			
			if (courseLevel4 == 1)
			{
				if (courseGrade4 >= 97)
					totalGPA += 4.0;
				else if (courseGrade4 >= 94)
					totalGPA +=3.8;
				else if (courseGrade4 >= 90)
					totalGPA +=3.6;
				else if (courseGrade4 >= 87)
					totalGPA +=3.4;
				else if (courseGrade4 >= 84)
					totalGPA +=3.2;
				else if (courseGrade4 >= 80)
					totalGPA +=3.0;
				else if (courseGrade4 >= 77)
					totalGPA +=2.8;
				else if (courseGrade4 >= 74)
					totalGPA +=2.6;
				else if (courseGrade4 >= 71)
					totalGPA +=2.4;
				else
					totalGPA +=2.2;
			}
			
			System.out.print("Enter Course 5 Level: ");
			int courseLevel5 = keyboard.nextInt();
			
			if  (courseLevel5 > 4 || courseLevel5 < 1) 
			{
				System.out.println("Incorrect course level entered! Please enter a value from 1-4.");
				System.exit(0);
			}

			System.out.print("Enter Course 5 grade: ");
			int courseGrade5 = keyboard.nextInt();
			
			if (courseGrade5 > 100 || courseGrade5 < 70)
			{
				System.out.println("Incorrect course grade entered! Please enter a grade from 70-100.");
				System.exit(0);
			}
			
			if (courseLevel5 == 4)
			{
				if (courseGrade5 >= 97)
					totalGPA += 6.0;
				else if (courseGrade5 >= 94)
					totalGPA +=5.8;
				else if (courseGrade5 >= 90)
					totalGPA += 5.6;
				else if (courseGrade5 >= 87)
					totalGPA +=5.4;
				else if (courseGrade5 >= 84)
					totalGPA +=5.2;
				else if (courseGrade5 >= 80)
					totalGPA +=5.0;
				else if (courseGrade5 >= 77)
					totalGPA += 4.8;
				else if (courseGrade5 >= 74)
					totalGPA += 4.6;
				else if (courseGrade5 >= 71)
					totalGPA +=4.4;
				else
					totalGPA +=4.0;
			}
			
			if (courseLevel5 == 3)
			{
				if (courseGrade5 >= 97)
					totalGPA += 5.5;
				else if (courseGrade5 >= 94)
					totalGPA +=5.3;
				else if (courseGrade5 >= 90)
					totalGPA += 5.1;
				else if (courseGrade5 >= 87)
					totalGPA +=4.9;
				else if (courseGrade5 >= 84)
					totalGPA +=4.7;
				else if (courseGrade5 >= 80)
					totalGPA +=4.5;
				else if (courseGrade5 >= 77)
					totalGPA += 4.3;
				else if (courseGrade5 >= 74)
					totalGPA += 4.1;
				else if (courseGrade5 >= 71)
					totalGPA +=3.9;
				else
					totalGPA +=3.7;
			}
			
			if (courseLevel5 == 2)
			{
				if (courseGrade5 >= 97)
					totalGPA +=5.0;
				else if (courseGrade5 >= 94)
					totalGPA +=4.8;
				else if (courseGrade5 >= 90)
					totalGPA +=4.6;
				else if (courseGrade5 >= 87)
					totalGPA +=4.4;
				else if (courseGrade5 >= 84)
					totalGPA +=4.2;
				else if (courseGrade5 >= 80)
					totalGPA +=4.0;
				else if (courseGrade5 >= 77)
					totalGPA +=3.8;
				else if (courseGrade5 >= 74)
					totalGPA +=3.6;
				else if (courseGrade5 >= 71)
					totalGPA +=3.4;
				else
					totalGPA +=3.2;
			}
			
			if (courseLevel5 == 1)
			{
				if (courseGrade5 >= 97)
					totalGPA += 4.0;
				else if (courseGrade5 >= 94)
					totalGPA +=3.8;
				else if (courseGrade5 >= 90)
					totalGPA +=3.6;
				else if (courseGrade5 >= 87)
					totalGPA +=3.4;
				else if (courseGrade5 >= 84)
					totalGPA +=3.2;
				else if (courseGrade5 >= 80)
					totalGPA +=3.0;
				else if (courseGrade5 >= 77)
					totalGPA +=2.8;
				else if (courseGrade5 >= 74)
					totalGPA +=2.6;
				else if (courseGrade5 >= 71)
					totalGPA +=2.4;
				else
					totalGPA +=2.2;
			}
		}
		
		System.out.println("Your average GPA is: " + (totalGPA/5));
	}	
}