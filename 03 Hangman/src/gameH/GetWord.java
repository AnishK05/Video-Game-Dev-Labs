package gameH;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GetWord 
{
	private static ArrayList<String>wordList = new ArrayList <>(); //Array list keeps growing (unlike array), so our list of words can keep growing if we choose to add words to the dict.txt file
	static Random rand = new Random(); //rand is an object of a class called Random. An object is an INSTANCE of a class.
	
	public static String guessWord() //static means you don't need to create/use an object inside this method. You can use certain method and variables without needing the object -- you will instead use the class that is storing those certain methods and variables.  
	{
		//Read in word list and select word
		try //Try these following statements. Java REQUIRES try and catch for files class!
		{
			File file = new File("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/dict.txt"); //Class in java that handles files for you
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				wordList.add(scan.nextLine()); 
			}
			scan.close();
		}
		catch (FileNotFoundException e) //If try statements don't work, this code should run -- it will prevent the computer from crashing and instead run a "safety" code. 
		{
			e.printStackTrace();
		}
		return wordList.get(rand.nextInt(wordList.size())); //rand gives a random integer -- it will start from 0 and end at the size of the wordList (how long wordList is)
	}
}
