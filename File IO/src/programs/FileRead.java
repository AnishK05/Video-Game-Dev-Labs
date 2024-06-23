package programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	public ArrayList<String> in = new ArrayList<String>();
	BufferedReader reader;
	private String fileName;

	public FileRead(String file) {
		fileName = file;

	}

	public void readFile() {
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {  //MAKE A WHILE LOOP THAT READS THE NEXT FILE LINE, AND CHCEKS IF THE FILE EXISTS!!
				in.add(line);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
